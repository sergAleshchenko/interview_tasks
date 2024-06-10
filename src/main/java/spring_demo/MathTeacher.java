package spring_demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author Sergei Aleshchenko
 */
@Component
public class MathTeacher implements Teacher {
    @Override
    public void teach() {
        System.out.println("Starting math class");
    }
}
