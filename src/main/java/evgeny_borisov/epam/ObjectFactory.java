package evgeny_borisov.epam;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance;
    private final ApplicationContext context;
    private List<ObjectConfigurator> configurators = new ArrayList<>();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    public ObjectFactory(ApplicationContext context) {
        this.context = context;
        for (Class<? extends ObjectConfigurator> aClass :
                context.getConfig().getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> implClass) {
        T t = implClass.getDeclaredConstructor().newInstance();

        configurators.forEach(
                objectConfigurator -> objectConfigurator.configure(t, context));

        return t;
    }
}
