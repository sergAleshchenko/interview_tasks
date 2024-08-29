package multithreading;

import java.util.concurrent.CountDownLatch;

/**
 * @author Sergei Aleshchenko
 */
public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdLatch = new CountDownLatch(4);

        Worker worker1 = new Worker(1000, cdLatch, "Worker Thread-1");
        Worker worker2 = new Worker(2000, cdLatch, "Worker Thread-2");
        Worker worker3 = new Worker(3000, cdLatch, "Worker Thread-3");
        Worker worker4 = new Worker(4000, cdLatch, "Worker Thread-4");

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        cdLatch.await();
        System.out.println("Thread " + Thread.currentThread().getName() + " has finished");
    }

}

class Worker extends Thread {
    private int delay;
    private CountDownLatch cdLatch;

    public Worker(int delay, CountDownLatch cdLatch, String name) {
        super(name);
        this.delay = delay;
        this.cdLatch = cdLatch;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            cdLatch.countDown();
            System.out.println(Thread.currentThread().getName() + " has finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
