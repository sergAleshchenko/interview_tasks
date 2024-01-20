package evgeny_borisov.spring_patterns.lazy_singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author Sergei Aleshchenko
 */
@Service
public class Schwarzenegger {
    @Autowired
    @Lazy
    private Ракетница ракетница;

    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        System.out.println(ракетница.getClass());
        if (враговМеньше100()) {
            битьБревном();
        } else {
            ракетница.бабах();
        }
    }

    private boolean враговМеньше100() {
        return true;
    }

    private void битьБревном() {
        System.out.println("тыдыщ тыдыщ!!");
    }
}
