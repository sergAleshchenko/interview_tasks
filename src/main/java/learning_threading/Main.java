package learning_threading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Sergei Aleshchenko
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting");
        NumbersTask task = new NumbersTask();

        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future<Double> result = pool.submit(task);

        while (!result.isDone()) {
            System.out.println("Still waiting");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException has been caught");
            }
        }

        try {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("InterruptedException has been caught");
        }

        System.out.println("Finished");

        pool.shutdown();
    }
}
