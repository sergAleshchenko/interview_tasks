package evgeny_borisov.spring_patterns.for_adult;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Sergei Aleshchenko
 */
@Component
public class Знахарь implements Целитель {
    @Autowired
    private Лечение водка;

    @Override
    public void исцелять(Patient patient) {
        System.out.println("определяю лечение...");
        водка.применить(patient);
    }
}
