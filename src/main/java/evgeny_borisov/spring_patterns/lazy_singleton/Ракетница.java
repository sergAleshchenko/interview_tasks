package evgeny_borisov.spring_patterns.lazy_singleton;

import lombok.Setter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author Sergei Aleshchenko
 */
@Service
@Lazy
public class Ракетница {

    @PostConstruct
    private void init() {
        System.out.println("Ракетница доставлена");
    }

    public void бабах() {
        System.out.println("Трах бабах!!!");
    }
}
