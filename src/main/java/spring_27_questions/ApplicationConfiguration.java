package spring_27_questions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
@Configuration
@ComponentScan("spring_27_questions")
public class ApplicationConfiguration {

    @Bean
    public List<String> bean1() {
        return Arrays.asList("Name1", "Name2", "Name3", "Name4");
    }
}
