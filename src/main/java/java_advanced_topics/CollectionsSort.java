package java_advanced_topics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
public class CollectionsSort {

    public static void main(String[] args) {
        String test1 = "hello";
        String test2 = "goodbye";

        System.out.println(test1.compareTo(test1));

        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");
        strings.add("five");
        strings.add("six");
        strings.add("seven");

        Collections.sort(strings);

//        strings.stream().sorted().forEach(System.out::println);

        System.out.println("----------------");
        strings.stream().forEach(System.out::println);

    }
}
