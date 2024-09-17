package selenium_express.spring_27_questions;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Sergei Aleshchenko
 */
@Component
@AllArgsConstructor
public class Student {

    @Autowired
//    @Qualifier("scienceTeacher")
    private Teacher teacher;

    public void learn() {
        teacher.teach();
        System.out.println("Learning");
    }
}
