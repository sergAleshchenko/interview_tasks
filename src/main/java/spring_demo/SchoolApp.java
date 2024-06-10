package spring_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author Sergei Aleshchenko
 */
@SpringBootApplication
public class SchoolApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SchoolApp.class, args);
        context.getBean(Student.class).learn();

        context.getBean(CollectionBean.class).printNames();

        Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());

        Runnable listOperations = () -> {
            syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        };

    }
}
