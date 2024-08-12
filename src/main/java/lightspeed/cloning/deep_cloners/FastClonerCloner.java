package lightspeed.cloning.deep_cloners;

import lightspeed.cloning.Cloner;
import lightspeed.cloning.DeepCloner;
import lightspeed.cloning.ShallowCloner;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Sergei Aleshchenko
 */
public class FastClonerCloner implements DeepCloner {
    private ShallowCloner fastCloner;
    private DeepCloner cloneInternal;
    private Cloner aCloner = new Cloner();
    private DeepCloner deepCloner = this::cloneInternal;
    private Map<Class, DeepCloner> cloners = new ConcurrentHashMap<>();
    private static DeepCloner IGNORE_CLONER = new IgnoreClassCloner();
    private static DeepCloner NULL_CLONER = new NullClassCloner();

    public FastClonerCloner(ShallowCloner fastCloner) {
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
        DeepCloner cloner = cloners.get(aClass);
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

