package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class StreamsDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.add("Seven");
        list.add("Eight");
        list.add("Nine");
        list.add("Ten");

//        list.stream().filter(x -> x.length() == 3).forEach(System.out::println);


        String[] array = {"Java", "Ruuussshhh"};
        Stream<String> streamOfArray = Arrays.stream(array);

        streamOfArray
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .toList()
                .forEach(System.out::println);


    }
}
