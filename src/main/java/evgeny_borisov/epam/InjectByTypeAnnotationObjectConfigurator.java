package evgeny_borisov.epam;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 * @author Sergei Aleshchenko
 */
public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object t, ApplicationContext context) {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                field.setAccessible(true);

                Object object = context.getObject(field.getType());

                field.set(t, object);
            }
        }
    }
}
