package interview_300_questions.spring_boot_demo.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Sergei Aleshchenko
 */
@Component
public class DemoClass {
    public DemoClass() {
        System.out.println("DemoClass has been scanned!");
    }
}
