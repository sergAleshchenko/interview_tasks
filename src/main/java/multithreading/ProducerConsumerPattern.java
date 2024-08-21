package multithreading;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sergei Aleshchenko
 */
public class ProducerConsumerPattern {
    public static void main(String[] args) {
        final Queue<Integer> sharedQueue = new LinkedList<>();

        Thread producer = new Producer(sharedQueue);
        Thread consumer = new Consumer(sharedQueue);

        producer.start();
        consumer.start();
    }

}

class Producer extends Thread {
     private final Queue<Integer> sharedQueue;


    public Producer(Queue<Integer> sharedQueue) {
        super("Producer");
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 4; i++) {
                synchronized (sharedQueue) {
                    while (sharedQueue.size() >= 1) {
                        System.out.println("Queue is full, waiting");
                        sharedQueue.wait();

                    }
                    Thread.sleep(1000);
                    System.out.println("Producing: " + i);
                    sharedQueue.add(i);
                    sharedQueue.notify();
                }

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Consumer extends Thread {
    private final Queue<Integer> sharedQueue;

    public Consumer(Queue<Integer> sharedQueue) {
        super("Consumer");
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (sharedQueue) {
                    while (sharedQueue.size() == 0) {
                        System.out.println("Queue is empty, waiting");
                        sharedQueue.wait();
                    }

                    Thread.sleep(1000);

                    int number = sharedQueue.poll();
                    System.out.println("Consuming: " + number);
                    sharedQueue.notify();

                    if (number == 3) {
                        break;
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
