package selenium_express.interview_examples;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Sergei Aleshchenko
 */
public class FunctionInterface {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> multiply =  (x, y) -> x * y;
        Function<Integer, Integer> twice =  x -> x * 2;

        BiFunction<Integer, Integer, Integer> function = multiply.andThen(twice);


        System.out.println(twice.apply(5));
        System.out.println(function.apply(2, 3));

    }
}
