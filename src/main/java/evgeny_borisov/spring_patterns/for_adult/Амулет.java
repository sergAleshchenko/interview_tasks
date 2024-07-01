package evgeny_borisov.spring_patterns.for_adult;

import org.springframework.stereotype.Component;

/**
 *
 * @author Sergei Aleshchenko
 */
@Component
public class Амулет implements Лечение {
    @Override
    public void применить(Patient patient) {
        System.out.println("Носить на шее маску. Не снимать ни в душе ни во сне");
    }
}
