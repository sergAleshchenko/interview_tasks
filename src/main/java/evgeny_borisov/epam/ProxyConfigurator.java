package evgeny_borisov.epam;

/**
 * @author Sergei Aleshchenko
 */
public interface ProxyConfigurator {
    Object replaceWithProxyIfNeeded(Object t, Class implClass);
}
