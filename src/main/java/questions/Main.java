package questions;



class Person {
    public String version = "Person";
}
class Student extends Person {
    private String version = "Student";
}
public class Main {



    public static void main(String[] args) {
        Person person = new Student ();
        System.out.println(person.version);
    }
}
