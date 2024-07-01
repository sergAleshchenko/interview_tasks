package evgeny_borisov.spring_patterns.for_adult;

import org.springframework.stereotype.Component;

/**
 *
 * @author Sergei Aleshchenko
 */
@Treatment(type = Лечение.АЛКОГОЛЬ)
@Component
public class Водка implements Лечение {
    @Override
    public void применить(Patient patient) {
        System.out.println("100 грамм водки внутрь, три раза перед каждой едой.");
    }
}
