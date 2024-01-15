package inners;

import java.util.Collection;

public class MainClass {
    public void changeObject(Student student) {
        student.setStudentId(12);
    }

    public static void main(String[] args) {
        Student.Address address = new Student().new Address();
        Student student = new Student();
        student.setStudentId(6);

        System.out.println(student.getStudentId());

        MainClass mainClass = new MainClass();
        mainClass.changeObject(student);
        System.out.println(student.getStudentId());
    }
}
