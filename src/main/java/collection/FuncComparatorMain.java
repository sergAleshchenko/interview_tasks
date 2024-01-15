package collection;

import entity.Person;

import java.util.ArrayList;
import java.util.Comparator;

public class FuncComparatorMain {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person(701, "Bob"));
        list.add(new Person(509, "Jack"));
        list.add(new Person(817, "Robin"));
        list.add(new Person(129, "Peter"));
        list.add(new Person(79, "Jack"));
        list.add(new Person(77, "Jack"));
        list.add(new Person(125, "Peter"));
        list.add(new Person(60, "Peter"));

//        System.out.println(list);

//        list.sort(((o1, o2) -> o1.getPersonId() - o2.getPersonId()));
        list.sort(Comparator.comparing(Person::getName).thenComparing(Person::getId));

        System.out.println(list);

    }
}
