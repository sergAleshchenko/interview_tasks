package multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Sergei Aleshchenko
 */
public class CyclicBarrierExample {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cb  = new CyclicBarrier(3, new AfterAction());

        Thread t1 = new Thread(new TxtReader("Thread-1", "File-1", cb));
        Thread t2 = new Thread(new TxtReader("Thread-2", "File-2", cb));
        Thread t3 = new Thread(new TxtReader("Thread-3", "File-3", cb));

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Done");

        ;
    }
}

class TxtReader implements Runnable {

    private String threadName;
    private String fileName;
    private CyclicBarrier cb;

    public TxtReader(String threadName, String fileName, CyclicBarrier cb) {
        this.threadName = threadName;
        this.fileName = fileName;
        this.cb = cb;
    }

    @Override
    public void run() {
        System.out.println("Reading file " + fileName + " thread " + threadName);

        try {
            cb.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}


class AfterAction implements Runnable {

    @Override
    public void run() {
        System.out.println("In after action class, start further processing as all files are read");
    }
}
