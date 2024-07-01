package evgeny_borisov.spring_patterns.for_adult;

import evgeny_borisov.spring_data.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Sergei Aleshchenko
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        context.getBean(Знахарь.class).исцелять(new Patient());
    }
}