package interview_300_questions;

import lombok.Getter;
import lombok.Setter;

import java.text.NumberFormat;
import java.util.Currency;

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
