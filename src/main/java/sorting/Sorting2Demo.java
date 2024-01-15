package sorting;

import java.util.*;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class Sorting2Demo {
    public static void main(String[] args) {
        Set<PersonSet> persons = new TreeSet<>();
        Random random = new Random();
        List<Object> objects = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            persons.add(new PersonSet(i, "name" + random.nextInt(100)));
        }

        System.out.println(persons);
    }
}

class PersonSet implements Comparable {
    private int id;
    private String name;

    public PersonSet(int id, String name) {
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
        return "PersonSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        PersonSet person = (PersonSet) o;
        return Integer.compare(this.getId(), person.getId());
    }
}
