package lightspeed.cloning;

import lightspeed.cloning.deep_cloners.*;
import lightspeed.cloning.utils.Logger;
import lightspeed.cloning.utils.Utils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Pattern;

public class Cloner {
	private final IInstantiationStrategy instantiationStrategy;
	private final Set<Class<?>> ignored = new HashSet<>();
	private final Set<Class<?>> ignoredInstanceOf = new HashSet<>();
	private final Map<Class<?>, IFastCloner> fastCloners = new HashMap<>();
	private Map<Object, Object> ignoredInstances;
	private Logger dumpCloned = new Logger();
	private boolean cloningEnabled = true;
	private Map<Class, IDeepCloner> cloners = new ConcurrentHashMap<>();
	private static IDeepCloner IGNORE_CLONER = new IgnoreClassCloner();
	private static IDeepCloner NULL_CLONER = new NullClassCloner();

	public Cloner() {
		this.instantiationStrategy = ObjenesisInstantiationStrategy.getInstance();
		init();
	}

	private void init() {
		registerKnownJdkImmutableClasses();
		registerFastCloners();
	}

	protected void registerFastCloners() {
		registerFastCloner(GregorianCalendar.class, new FastClonerCalendar());
		registerFastCloner(ArrayList.class, new FastClonerArrayList());
		registerFastCloner(LinkedList.class, new FastClonerLinkedList());
		registerFastCloner(HashSet.class, new FastClonerHashSet());
		registerFastCloner(HashMap.class, new FastClonerHashMap());
		registerFastCloner(TreeMap.class, new FastClonerTreeMap());
		registerFastCloner(TreeSet.class, new FastClonerTreeSet());
		registerFastCloner(LinkedHashMap.class, new FastClonerLinkedHashMap());
		registerFastCloner(ConcurrentHashMap.class, new FastClonerConcurrentHashMap());
		registerFastCloner(ConcurrentLinkedQueue.class, new FastClonerConcurrentLinkedQueue());
		registerFastCloner(EnumMap.class, new FastClonerEnumMap());
		registerFastCloner(LinkedHashSet.class, new FastClonerLinkedHashSet());
	}

	protected void registerKnownJdkImmutableClasses() {
		registerImmutable(String.class);
		registerImmutable(Integer.class);
		registerImmutable(Long.class);
		registerImmutable(Boolean.class);
		registerImmutable(Class.class);
		registerImmutable(Float.class);
		registerImmutable(Double.class);
		registerImmutable(Character.class);
		registerImmutable(Byte.class);
		registerImmutable(Short.class);
		registerImmutable(Void.class);

		registerImmutable(BigDecimal.class);
		registerImmutable(BigInteger.class);
		registerImmutable(URI.class);
		registerImmutable(URL.class);
		registerImmutable(UUID.class);
		registerImmutable(Pattern.class);
	}

	public void registerImmutable(final Class<?>... c) {
		for (final Class<?> cl : c) {
			ignored.add(cl);
		}
	}


	public void registerFastCloner(final Class<?> c, final IFastCloner fastCloner) {
		if (fastCloners.containsKey(c)) throw new IllegalArgumentException(c + " already fast-cloned!");
		fastCloners.put(c, fastCloner);
	}


	public <T> T deepClone(final T o) {
		if (o == null) return null;
		if (!cloningEnabled) return o;

		dumpCloned.startCloning(o.getClass());

		Map<Object, Object> clones = new ClonesMap();
		return cloneInternal(o, clones);
	}

	@SuppressWarnings("unchecked")
	public <T> T cloneInternal(T o, Map<Object, Object> clones) {
		if (o == null) return null;
		if (o == this) return null;

		// Prevent cycles, expensive but necessary
		if (clones != null) {
			T clone = (T) clones.get(o);
			if (clone != null) {
				return clone;
			}
		}

		Class<?> aClass = o.getClass();
		IDeepCloner cloner = cloners.get(aClass);
		if (cloner == null) {
			cloner = findDeepCloner(aClass);
			cloners.put(aClass, cloner);
		}
		if (cloner == IGNORE_CLONER) {
			return o;
		} else if (cloner == NULL_CLONER) {
			return null;
		}
		return cloner.deepClone(o, clones);
	}

	public IDeepCloner findDeepCloner(Class<?> clz) {
		if (ignored.contains(clz)) {
			return IGNORE_CLONER;
		} else if (clz.isArray()) {
			return new CloneArrayCloner(clz);
		} else {
			final IFastCloner fastCloner = fastCloners.get(clz);
			if (fastCloner != null) {
				return new FastClonerCloner(fastCloner);
			} else {
				for (final Class<?> iClz : ignoredInstanceOf) {
					if (iClz.isAssignableFrom(clz)) {
						return IGNORE_CLONER;
					}
				}
			}
		}
		return new CloneObjectCloner(clz);
	}

	private class ClonesMap extends IdentityHashMap<Object, Object> {
		@Override
		public Object get(Object key) {
			if (ignoredInstances != null) {
				Object o = ignoredInstances.get(key);
				if (o != null) return o;
			}
			return super.get(key);
		}
	}
}
