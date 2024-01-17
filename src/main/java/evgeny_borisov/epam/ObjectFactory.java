package evgeny_borisov.epam;

import lombok.SneakyThrows;

import java.io.ObjectInputFilter;
import java.lang.invoke.SerializedLambda;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergei Aleshchenko
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config;

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
        new JavaConfig("evgeny_borisov.epam",
                new HashMap<>(Map.of(Policeman.class, AngryPoliceman.class)));
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> implClass = type;
        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }

        T t = implClass.getDeclaredConstructor().newInstance();

        //TODO

        return t;
    }
}
