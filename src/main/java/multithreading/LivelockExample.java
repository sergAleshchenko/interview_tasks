package multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Sergei Aleshchenko
 */
public class LivelockExample {

    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {

        LivelockExample liveLock = new LivelockExample();

        new Thread(liveLock::operation1).start();
        new Thread(liveLock::operation2).start();
    }

    public void operation1() {
        while (true) {

            try {
                lock1.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("lock1 acquired, trying to acquire lock2");

                Thread.sleep(50);
                if (lock2.tryLock()) {
                    System.out.println("lock2 acquired");
                } else {
                    System.out.println("Cannot acquire lock2, releasing lock1");
                    lock1.unlock();
                    continue;
                }
                System.out.println("Executing first operation");
                break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        lock2.unlock();
        lock1.unlock();
    }

    public void operation2() {
        while (true) {


            try {
                lock2.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("lock2 acquired, trying to acquire lock1");

                Thread.sleep(50);

                if (lock1.tryLock()) {
                    System.out.println("lock1 acquired");
                } else {
                    System.out.println("cannot acquire lock1, releasing lock2");
                    lock2.unlock();
                    continue;
                }

                System.out.println("Executing second operation");
                break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        lock1.unlock();
        lock2.unlock();
    }

}
