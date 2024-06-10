package spring_demo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
