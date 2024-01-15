package course;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class CallableFutureDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        thread.interrupt();


        Future<Integer> future = executorService.submit(() -> {
            System.out.println("Starting");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Finished");
            Random random = new Random();
            int randomValue = random.nextInt();

            if (randomValue < 5) {
                throw new Exception("Something bad happened");
            }
            return random.nextInt(10);
        });

        executorService.shutdown();

        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            Throwable cause = e.getCause();
            System.out.println("The exception has been caught. Cause: " + cause.getMessage());
        }

    }

    public static int calculate() {
        return 5 + 4;
    }
}
