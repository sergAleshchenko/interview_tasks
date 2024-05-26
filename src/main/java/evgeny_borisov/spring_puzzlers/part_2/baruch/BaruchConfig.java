package evgeny_borisov.spring_puzzlers.part_2.baruch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Sergei Aleshchenko
 */
@Configuration
public class BaruchConfig {

    @Bean
    public String str1() {
        return "Groovy";
    }

    @Bean
    public String str2() {
        return "Spring";
    }
}
