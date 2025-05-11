package selenium_express.spring_27_questions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;

/**
 * @author Sergei Aleshchenko
 */
@SpringBootApplication
public class  SchoolApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SchoolApp.class, args);

        context.getBean(Student.class).learn();
        context.getBean(CollectionBean.class).printNames();
        context.getBean(CollectionBean.class).printBunchOfNames();

        context.getBean(SpelBean.class).printFields();
    }
}
