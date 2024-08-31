package multithreading.locking;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Sergei Aleshchenko
 */
public class CounterWithLock {
    private static int counter;
    private static final ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                lock.lock();

                try {
                    counter++;
                } finally {
                    lock.unlock();
                }
            });

            threads[i].start();
        }


        for (Thread thread : threads) {
            thread.join();
        }

//        Thread.currentThread().join();

        System.out.println("Counter with lock (pessimistic locking): " + counter);
    }
}
