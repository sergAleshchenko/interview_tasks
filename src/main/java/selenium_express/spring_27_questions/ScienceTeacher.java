package selenium_express.spring_27_questions;

import org.springframework.stereotype.Component;

/**
 * @author Sergei Aleshchenko
 */
@Component
public class ScienceTeacher implements Teacher {
    @Override
    public void teach() {
        System.out.println("Starting the science class");
    }
}
