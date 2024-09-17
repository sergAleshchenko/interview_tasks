package selenium_express.spring_27_questions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
@Component
@Getter
@Setter
public class CollectionBean {

    @Autowired
    private List<String> notNames;

    @Autowired
    private List<String> anotherBunchOfNames;

    public void printNames() {
        System.out.println(notNames);
    }

    public void printBunchOfNames() {
        System.out.println(anotherBunchOfNames);
    }

}
