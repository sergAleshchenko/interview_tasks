package evgeny_borisov.epam;

import lombok.Getter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

/**
 * @author Sergei Aleshchenko
 */
public class JavaConfig implements Config {
    @Getter
    private Reflections scanner;
    private Map<Class, Class> ifc2ImplClass;

    public JavaConfig(String packageToScan, Map<Class, Class> ifc2ImplClass) {
        this.ifc2ImplClass = ifc2ImplClass;
        this.scanner = new Reflections(packageToScan);
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        return ifc2ImplClass.computeIfAbsent(ifc, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
            if (classes.size() != 1) {
                throw new RuntimeException(ifc +
                        " has 0 or more than one impl please update you config");
            }

            return classes.iterator().next();
        });
    }
}
