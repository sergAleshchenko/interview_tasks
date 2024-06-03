package interview_300_questions;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Sergei Aleshchenko
 */
@Getter
@Setter
public class Person {
    private String name;
    private String address;
    private int age;

    public Person(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }
}
