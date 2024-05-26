package evgeny_borisov.spring_puzzlers.part_2.baruch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
@Configuration
public class JekaConfig {

    @Bean
    public List<String> messages() {
        List<String> strings = new ArrayList<>();
        strings.add("Groovy");
        strings.add("Spring");
        return strings;
    }
}
