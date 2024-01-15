package others;

import entity.Person;
import entity.PersonNameComparator;
import entity.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WildSuperMain {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
//        students.add(new Student());
        students.sort(new PersonNameComparator());
        students.sort((Comparator.comparing(Person::getName)));

        List<Person> persons = new ArrayList<>();


        action(students);
        action(persons);
    }

    static void action(List<? super Student> list) {
        list.remove(0);
//        list.add(new Student());
//        list.add(new others.Person());
    }
}
