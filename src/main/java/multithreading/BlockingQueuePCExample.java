package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Sergei Aleshchenko
 */
public class BlockingQueuePCExample {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }

    static class Producer implements Runnable {
        BlockingQueue<String> queue;

        public Producer(BlockingQueue<String> queue) {
            super();
            this.queue = queue;
        }

        @Override
        public void run() {

            try {
                int i = 0;
                while (true) {
                    System.out.println("Producing element " + ++i);
                    queue.put("Element " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class Consumer implements Runnable {
        BlockingQueue<String> queue;


        public Consumer(BlockingQueue<String> queue) {
            super();
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Consumed " + queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
