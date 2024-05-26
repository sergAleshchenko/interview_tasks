package evgeny_borisov.spring_puzzlers.part_1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author Sergei Aleshchenko
 */
@Configuration
public class JavaConfig {

    @Bean
    @Scope("singleton")
    public String str() {
        return "WTF";
    }
}
