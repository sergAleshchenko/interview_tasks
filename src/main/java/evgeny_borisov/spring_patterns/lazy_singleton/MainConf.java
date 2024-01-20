package evgeny_borisov.spring_patterns.lazy_singleton;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Sergei Aleshchenko
 */
@Configuration
@ComponentScan
public class MainConf {
    public static void main(String[] args) {
        SpringApplication.run(MainConf.class);
    }
}
