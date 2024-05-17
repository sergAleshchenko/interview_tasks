package interview_questions_300;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Sergei Aleshchenko
 */
@Getter
@Setter
public class Employee extends Person {

    private float salary;

    public Employee(String name, String address, int age, float salary) {
        super(name, address, age);
        this.salary = salary;
    }
}
