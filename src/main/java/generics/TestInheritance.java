package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
public class TestInheritance {
    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();

        numbers.add(16);
        numbers.add(107L);
        numbers.add(152.09);

        numbers.stream().forEach(System.out::println);

        Double total = 0d;
        for (Number number : numbers) {
            total += number.doubleValue();
        }

        System.out.println(total);


    }
}
