package evgeny_borisov.epam;

import org.reflections.Reflections;

/**
 * @author Sergei Aleshchenko
 */
public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> ifc);

    Reflections getScanner();
}
