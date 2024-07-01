package evgeny_borisov.spring_patterns.for_adult;

import org.springframework.stereotype.Component;

/**
 * @author Sergei Aleshchenko
 */
@Component
public class Дым implements Лечение {
    @Override
    public void применить(Patient patient) {
        System.out.println("Нюхать дым, стучать в барабан до полного исцеления.");
    }
}
