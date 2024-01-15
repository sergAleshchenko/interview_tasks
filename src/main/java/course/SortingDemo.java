package course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class SortingDemo {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();

        animals.add("dog123423");
        animals.add("dog");
        animals.add("cat");
        animals.add("frog");
        animals.add("fr");
        animals.add("bird");
        animals.add("b");

        Collections.sort(animals, Comparator.comparingInt(String::length));
        System.out.println(animals);

        List<Integer> numbers = new ArrayList<>();

        numbers.add(5);
        numbers.add(0);
        numbers.add(500);
        numbers.add(100);
        numbers.add(130);
        numbers.add(500);
        numbers.add(1);

        Collections.sort(numbers, Comparator.reverseOrder());
        System.out.println(numbers);

        List<Person1> people = new ArrayList<>();
        people.add(new Person1(3, "Bob"));
        people.add(new Person1(4, "Tom"));
        people.add(new Person1(1, "Katy"));
        people.add(new Person1(7, "John"));

        Collections.sort(people, Comparator.comparingInt(Person1::getId));

        System.out.println(people);
    }
}

class Person1 {
    private  int id;
    private String name;

    public Person1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}' + '\n';
    }
}

