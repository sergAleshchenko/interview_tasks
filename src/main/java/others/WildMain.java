package others;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import entity.Person;
import entity.Student;

public class WildMain {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person());
//        persons.add(new Student());

        List<Student> students = new ArrayList<>();
//        students.add(new Student());

        action(students);
        action(persons);
    }

    static void action(List<? extends Person> list) {
        list.remove(0);
//        list.add(new others.Person());
        Stream<? extends Person> stream = list.stream();

    }
}
