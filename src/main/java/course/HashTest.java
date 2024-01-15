package course;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class HashTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

//        map.put(1, "One");
//        map.put(1, "Another one");
//
//        set.add(1);
//        set.add(1);
//
//        System.out.println(map);
//        System.out.println(set);

        Map<Person, String> personMap = new HashMap<>();
        Set<Person> personSet = new HashSet<>();

        Person person1 = new Person(1, "Mike");
        Person person2 = new Person(1, "Mike");

        personMap.put(person1, "123");
        personMap.put(person2, "321");

        personSet.add(person1);
        personSet.add(person2);

        System.out.println(personMap);
        System.out.println(personSet);

        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
    }
}

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
