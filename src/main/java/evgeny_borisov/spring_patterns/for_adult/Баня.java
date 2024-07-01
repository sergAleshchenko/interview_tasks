package evgeny_borisov.spring_patterns.for_adult;

import org.springframework.stereotype.Component;

/**
 * @author Sergei Aleshchenko
 */
@Component
public class Баня implements Лечение {
    @Override
    public void применить(Patient patient) {
        System.out.println("Три захода в баню, по 10 минут при температуре в 3" +
                "раза превышающей температуру тела.");
    }
}
