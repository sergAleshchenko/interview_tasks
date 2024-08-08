package multithreading;

import java.util.concurrent.*;

/**
 * @author Sergei Aleshchenko
 */
public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<String> task = () -> {
            System.out.println("Task running...");
            Thread.sleep(2000);
            return "Hello, World!";
        };

        Future<String> future = executor.submit(task);
        String result = future.get();

        System.out.println("Result: " + result);
        executor.shutdown();
    }
}
