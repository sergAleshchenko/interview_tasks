package evgeny_borisov.epam;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.ObjectInputFilter;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

/**
 * @author Sergei Aleshchenko
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private Config config;

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
        config = new JavaConfig("evgeny_borisov.epam",
                new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class)));
        for (Class<? extends ObjectConfigurator> aClass :
                config.getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> implClass = type;
        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }

        T t = implClass.getDeclaredConstructor().newInstance();

        configurators.forEach(
                objectConfigurator -> objectConfigurator.configure(t));

        return t;
    }
}
