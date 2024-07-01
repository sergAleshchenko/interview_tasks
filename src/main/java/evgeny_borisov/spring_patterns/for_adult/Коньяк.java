package evgeny_borisov.spring_patterns.for_adult;

import org.springframework.stereotype.Component;

/**
 * @author Sergei Aleshchenko
 */
@Treatment(type = Лечение.АЛКОГОЛЬ)
@Component
public class Коньяк implements Лечение {
    @Override
    public void применить(Patient patient) {
        System.out.println("Дышать над коньячной баней.");
    }
}
