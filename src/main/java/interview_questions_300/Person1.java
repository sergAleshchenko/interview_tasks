package interview_questions_300;

/**
 * @author Sergei Aleshchenko
 */
public class Person1 {
    public Person1() {
        this.printThis();
        System.out.println("Person class constructor called");
    }

    void printThis() {
        System.out.println(this);
    }
}
