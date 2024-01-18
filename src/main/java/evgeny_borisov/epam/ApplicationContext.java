package evgeny_borisov.epam;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Sergei Aleshchenko
 */
public class ApplicationContext {
    private ObjectFactory factory;
    private Map<Class, Object> cache = new ConcurrentHashMap<>();

    public <T> T getObject(Class<T> type) {
        return null;
    }
}
