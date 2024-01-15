package streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */

@Deprecated
public class StreamAverage {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6, 7, 3, 2, 7, 8, 22, 6, 3, 4);

        double average = list.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);

//        System.out.println(average);

        List<String> stringList = Arrays.asList("maaAA", "abbb", "zbcCc", "bDDD", "ncEEE");

        List<String> result =
                stringList.stream().map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(result);

        List<String> result2 =
                stringList.stream().map(String::toLowerCase).collect(Collectors.toList());

        System.out.println(result2);

        int result3 = list.stream().filter(x -> x % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println(result3);

        int result4 = list.stream().filter(x -> x % 2 != 0).mapToInt(Integer::intValue).sum();
        System.out.println(result4);

        List<Integer> result5 = list.stream().distinct().collect(Collectors.toList());
        System.out.println(result5);

        long result6 = stringList.stream().filter(x -> x.startsWith("b")).count();
        System.out.println(result6);

        List<String> result7 = stringList.stream().sorted().collect(Collectors.toList());
        System.out.println(result7);

        Integer integer = list.stream().min(Integer::compareTo).orElse(0);
        System.out.println(integer);

        Integer integer1 = list.stream().max(Integer::compareTo).orElse(0);
        System.out.println(integer1);



        AtomicInteger counter = new AtomicInteger();
        Collection<List<Integer>> values =
                list.stream().collect(Collectors.groupingBy(it -> counter.getAndIncrement() / 3)).values();

        System.out.println(values);
    }

}
