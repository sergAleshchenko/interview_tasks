package selenium_express.spring_27_questions;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author Sergei Aleshchenko
 */
@Component
@Primary
public class MathTeacher implements Teacher {
    @Override
    public void teach() {
        System.out.println("Starting math class");
    }
}
