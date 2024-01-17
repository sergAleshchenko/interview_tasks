package evgeny_borisov.epam;

/**
 * @author Sergei Aleshchenko
 */
public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> ifc);
}
