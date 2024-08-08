package lightspeed.cloning.utils;

import lightspeed.cloning.Immutable;

import java.lang.annotation.Annotation;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Sergei Aleshchenko
 */
public class Utils {
    private final ConcurrentHashMap<Class<?>, Boolean> immutables = new ConcurrentHashMap<>();

    /**
     * decides if a class is to be considered immutable or not
     *
     * @param clz the class under check
     * @return true if the clz is considered immutable
     */
    public boolean isImmutable(final Class<?> clz) {
        final Boolean isIm = immutables.get(clz);
        if (isIm != null) return isIm;
        if (considerImmutable(clz)) return true;

        final Class<?> immutableAnnotation = getImmutableAnnotation();
        for (final Annotation annotation : clz.getDeclaredAnnotations()) {
            if (annotation.annotationType() == immutableAnnotation) {
                immutables.put(clz, Boolean.TRUE);
                return true;
            }
        }
        Class<?> c = clz.getSuperclass();
        while (c != null && c != Object.class) {
            for (final Annotation annotation : c.getDeclaredAnnotations()) {
                if (annotation.annotationType() == Immutable.class) {
                    final Immutable im = (Immutable) annotation;
                    if (im.subClass()) {
                        immutables.put(clz, Boolean.TRUE);
                        return true;
                    }
                }
            }
            c = c.getSuperclass();
        }
        immutables.put(clz, Boolean.FALSE);
        return false;
    }

    /**
     * override this to decide if a class is immutable. Immutable classes are not cloned.
     *
     * @param clz the class under check
     * @return true to mark clz as immutable and skip cloning it
     */
    protected boolean considerImmutable(final Class<?> clz) {
        return false;
    }

    protected Class<?> getImmutableAnnotation() {
        return Immutable.class;
    }

}
