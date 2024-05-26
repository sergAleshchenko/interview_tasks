package evgeny_borisov.spring_puzzlers.part_2.evgeny;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Sergei Aleshchenko
 */
@Configuration
public class Config {
    @Bean
    public Вода вода() {
        return new Вода();
    }

    @Bean
    public СуперДуперУтюг суперДуперУтюг() {
        return new СуперДуперУтюг();
    }

    @Bean
    public Паяльник паяльник() {
        return new ПытательныйПаяльник();
    }
}
