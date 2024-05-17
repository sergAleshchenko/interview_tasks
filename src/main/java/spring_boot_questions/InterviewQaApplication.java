package spring_boot_questions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Sergei Aleshchenko
 */
@SpringBootApplication
public class InterviewQaApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(InterviewQaApplication.class);

    }
}
