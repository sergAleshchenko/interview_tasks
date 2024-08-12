package lightspeed.cloning.deep_cloners;

import lightspeed.cloning.Cloner;
import lightspeed.cloning.DeepCloner;
import lightspeed.cloning.utils.Logger;
import lightspeed.cloning.utils.Utils;

import java.lang.reflect.Array;
import java.util.Map;

/**
 * @author Sergei Aleshchenko
 */
public class CloneArrayCloner implements DeepCloner {
    private boolean primitive;
    private boolean immutable;
    private Class<?> componentType;
    private Utils utils = new Utils();
    private Logger dumpCloned = new Logger();
    private Cloner cloner = new Cloner();


    public CloneArrayCloner(Class<?> clz) {
        primitive = clz.getComponentType().isPrimitive();
        immutable = utils.isImmutable(clz.getComponentType());
        componentType = clz.getComponentType();
    }

    public <T> T deepClone(T o, Map<Object, Object> clones) {
        if (dumpCloned != null) {
            dumpCloned.startCloning(o.getClass());
        }
        int length = Array.getLength(o);
        @SuppressWarnings("unchecked") T newInstance = (T) Array.newInstance(componentType, length);
        if (clones != null) {
            clones.put(o, newInstance);
        }
        if (primitive || immutable) {
            System.arraycopy(o, 0, newInstance, 0, length);
        } else {
            if (clones == null) {
                for (int i = 0; i < length; i++) {
                    Array.set(newInstance, i, Array.get(o, i));
                }
            } else {
                for (int i = 0; i < length; i++) {
                    Array.set(newInstance, i, cloner.cloneInternal(Array.get(o, i), clones));
                }
            }
        }
        return newInstance;
    }
}