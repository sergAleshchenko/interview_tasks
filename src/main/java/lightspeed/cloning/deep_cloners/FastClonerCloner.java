package lightspeed.cloning.deep_cloners;

import lightspeed.cloning.Cloner;
import lightspeed.cloning.IDeepCloner;
import lightspeed.cloning.IFastCloner;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Sergei Aleshchenko
 */
public class FastClonerCloner implements IDeepCloner {
    private IFastCloner fastCloner;
    private IDeepCloner cloneInternal;
    private Cloner aCloner = new Cloner();
    private IDeepCloner deepCloner = this::cloneInternal;
    private Map<Class, IDeepCloner> cloners = new ConcurrentHashMap<>();
    private static IDeepCloner IGNORE_CLONER = new IgnoreClassCloner();
    private static IDeepCloner NULL_CLONER = new NullClassCloner();

    public FastClonerCloner(IFastCloner fastCloner) {
        this.fastCloner = fastCloner;
        this.cloneInternal = deepCloner;
    }

    public <T> T deepClone(T o, Map<Object, Object> clones) {
        @SuppressWarnings("unchecked") T clone = (T) fastCloner.clone(o, cloneInternal, clones);
        if (clones != null) clones.put(o, clone);
        return clone;
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
            cloner = aCloner.findDeepCloner(aClass);
            cloners.put(aClass, cloner);
        }
        if (cloner == IGNORE_CLONER) {
            return o;
        } else if (cloner == NULL_CLONER) {
            return null;
        }
        return cloner.deepClone(o, clones);
    }
}

