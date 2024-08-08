package lightspeed.cloning.deep_cloners;

import lightspeed.cloning.*;
import lightspeed.cloning.utils.Logger;
import org.objenesis.instantiator.ObjectInstantiator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * @author Sergei Aleshchenko
 */
public class CloneObjectCloner implements IDeepCloner {
    private final Field[] fields;
    private final boolean[] shouldClone;
    private final int numFields;
    private final ObjectInstantiator<?> instantiator;
    private Logger dumpCloned = new Logger();

    private boolean nullTransient = false;
    private boolean cloneSynthetics = true;
    private static final Field[] EMPTY_FIELD_ARRAY = new Field[0];

    private IInstantiationStrategy instantiationStrategy;
    private boolean cloneAnonymousParent = true;

    private final Set<Class<? extends Annotation>> nullInsteadFieldAnnotations = new HashSet<>();

    private Cloner cloner = new Cloner();

    public CloneObjectCloner(Class<?> clz) {
        this.instantiationStrategy = ObjenesisInstantiationStrategy.getInstance();
        List<Field> l = new ArrayList<>();
        List<Boolean> shouldCloneList = new ArrayList<>();
        Class<?> sc = clz;
        do {
            Field[] fs = sc.getDeclaredFields();
            for (final Field f : fs) {
                int modifiers = f.getModifiers();
                boolean isStatic = Modifier.isStatic(modifiers);
                if (!isStatic) {
                    if (!f.isAccessible()) {
                        f.setAccessible(true);
                    }
                    if (!(nullTransient && Modifier.isTransient(modifiers)) && !isFieldNullInsteadBecauseOfAnnotation(f)) {
                        l.add(f);
                        boolean shouldClone = (cloneSynthetics || !f.isSynthetic()) && (cloneAnonymousParent || !isAnonymousParent(f));
                        shouldCloneList.add(shouldClone);
                    }
                }
            }
        } while ((sc = sc.getSuperclass()) != Object.class && sc != null);
        fields = l.toArray(EMPTY_FIELD_ARRAY);
        numFields = fields.length;
        shouldClone = new boolean[numFields];
        for (int i = 0; i < shouldCloneList.size(); i++) {
            shouldClone[i] = shouldCloneList.get(i);
        }
        instantiator = instantiationStrategy.getInstantiatorOf(clz);
    }

    private boolean isFieldNullInsteadBecauseOfAnnotation(Field f) {
        if(!nullInsteadFieldAnnotations.isEmpty()) {
            for (Annotation annotation : f.getAnnotations()) {
                boolean isAnnotatedWithNullInsteadAnnotation =
                        nullInsteadFieldAnnotations.contains(annotation.annotationType());
                if (isAnnotatedWithNullInsteadAnnotation) {
                    return true;
                }
            }
        }
        return false;
    }

    public <T> T deepClone(T o, Map<Object, Object> clones) {
        try {
            if (dumpCloned != null) {
                dumpCloned.startCloning(o.getClass());
            }
            @SuppressWarnings("unchecked") T newInstance = (T) instantiator.newInstance();
            if (clones != null) {
                clones.put(o, newInstance);
                for (int i = 0; i < numFields; i++) {
                    Field field = fields[i];
                    Object fieldObject = field.get(o);
                    Object fieldObjectClone = shouldClone[i] ? cloner.cloneInternal(fieldObject, clones) : fieldObject;
                    field.set(newInstance, fieldObjectClone);
                    if (dumpCloned != null && fieldObjectClone != fieldObject) {
                        dumpCloned.cloning(field, o.getClass());
                    }
                }
            } else {
                // Shallow clone
                for (int i = 0; i < numFields; i++) {
                    Field field = fields[i];
                    field.set(newInstance, field.get(o));
                }
            }
            return newInstance;
        } catch (IllegalAccessException e) {
            throw new CloningException(e);
        }
    }

    private boolean isAnonymousParent(final Field field) {
        return "this$0".equals(field.getName());
    }
}
