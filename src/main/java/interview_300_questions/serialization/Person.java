package interview_300_questions.serialization;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Sergei Aleshchenko
 */
@Getter
@Setter
public class Person implements Serializable {

    private String name = "";

    public Person(String name) {
        this.name = name;
    }
}
