package evgeny_borisov.epam;

import java.util.Map;

/**
 * @author Sergei Aleshchenko
 */
public class Application {
    public static ApplicationContext run(String packageToScan,
                                  Map<Class, Class> ifc2ImplClass) {

        JavaConfig config = new JavaConfig(packageToScan, ifc2ImplClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory objectFactory = new ObjectFactory(context);

        context.setFactory(objectFactory);
        return context;
    }
}
