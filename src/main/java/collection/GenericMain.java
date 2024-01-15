package collection;

import entity.Person;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class GenericMain {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        list.add(new Student());
        list.add(new Student());

        list.add(new Person());
        Person person = list.get(1);


    }
}
