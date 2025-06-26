package streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class ParallelStream {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);

        listOfNumbers
                .forEach(x -> System.out.println(x + " " + Thread.currentThread().getName()));

        listOfNumbers.parallelStream()
                .forEach(x -> System.out.println(x + " " + Thread.currentThread().getName()));

        Integer result = listOfNumbers.stream().reduce(5, Integer::sum);
        System.out.println(result);

        Integer result2 = listOfNumbers.parallelStream().reduce(5, Integer::sum);
        System.out.println(result2);

        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        Integer result3 = forkJoinPool.submit(() -> listOfNumbers.parallelStream().reduce(5, Integer::sum)).get();
        forkJoinPool.shutdown();
        System.out.println(result3);


    }
}
