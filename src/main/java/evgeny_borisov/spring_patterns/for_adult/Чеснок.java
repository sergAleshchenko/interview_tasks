package evgeny_borisov.spring_patterns.for_adult;

import org.springframework.stereotype.Component;

/**
 * @author Sergei Aleshchenko
 */
@Component
public class Чеснок implements Лечение {
    @Override
    public void применить(Patient patient) {
        System.out.println("Вставить чеснок в уши, нос и рот, крутить по часовой стрелке" +
                "во время еды, до конца пандемии.");
    }
}
