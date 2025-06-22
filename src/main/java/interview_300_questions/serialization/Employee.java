package interview_300_questions.serialization;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Sergei Aleshchenko
 */
@Setter
@Getter
public class Employee extends Person {
    private float salary;

    public Employee(String name, float salary) {
        super(name);
        this.salary = salary;
    }


//    private void writeObject(ObjectOutputStream out) throws IOException {
//        throw new NotSerializableException();
//    }
//
//    private void readObject(ObjectInputStream in) throws IOException {
//        throw new NotSerializableException();
//    }
}
