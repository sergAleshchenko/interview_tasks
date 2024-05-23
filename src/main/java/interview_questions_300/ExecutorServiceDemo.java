package interview_questions_300;

import java.util.concurrent.*;

/**
 * @author Sergei Aleshchenko
 */
public class ExecutorServiceDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService executorService =
                Executors.newSingleThreadScheduledExecutor();

        ScheduledFuture<String> schedule =
                executorService.schedule(() -> "Hello world", 1, TimeUnit.SECONDS);

        System.out.println(schedule.get());

        executorService.schedule(() -> {
            System.out.println("Schedule hello world");
        },1, TimeUnit.SECONDS);

        executorService.shutdown();


    }
}
