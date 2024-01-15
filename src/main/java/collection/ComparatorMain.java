package collection;

import entity.Person;

import java.util.ArrayList;

public class ComparatorMain {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person(701, "Bob"));
        list.add(new Person(509, "Jack"));
        list.add(new Person(817, "Robin"));
        list.add(new Person(120, "Peter"));



//        Collections.sort(list, new PersonNameComparator());
        System.out.println(list);

    }
}
