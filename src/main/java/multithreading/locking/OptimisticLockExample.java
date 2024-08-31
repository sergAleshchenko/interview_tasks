package multithreading.locking;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Sergei Aleshchenko
 */
public class OptimisticLockExample {
    private static AtomicInteger counter = new AtomicInteger(0);
    private static int version = 0;


    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                int localCounter;

                do {
                    localCounter = counter.get();
                } while (!counter.compareAndSet(localCounter, localCounter + 1));
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Counter value after optimistic locking: " + counter);

    }
}
