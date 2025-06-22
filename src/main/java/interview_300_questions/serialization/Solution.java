package interview_300_questions.serialization;

import java.io.*;

/**
 * @author Sergei Aleshchenko
 */
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee emp = new Employee("Sharma", 10000);

        System.out.println("name = " + emp.getName());
        System.out.println("salary = " + emp.getSalary());

        FileOutputStream fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(emp);

        oos.close();
        fos.close();

        System.out.println("Object has been serialized");

        FileInputStream f = new FileInputStream("abc.txt");
        ObjectInputStream o = new ObjectInputStream(f);

        Employee emp1 = (Employee) o.readObject();

        o.close();
        f.close();

        System.out.println("Object has been deserialized");


        System.out.println("name = " + emp1.getName());
        System.out.println("salary = " + emp1.getSalary());

    }
}
