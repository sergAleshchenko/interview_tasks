package course;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class WaitAndNotifyDemo {;

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer wn = new ProducerConsumer();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class ProducerConsumer {
    private Object lock = new Object();

    public void produce() throws InterruptedException {
        synchronized (lock) {
            System.out.println("Producer thread started...");
            lock.wait();
            System.out.println("Producer thread resumed...");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);

        synchronized (lock) {
            System.out.println("Waiting for return key pressed");
            scanner.nextLine();
            lock.notify();

            Thread.sleep(5000);
        }
    }
}
