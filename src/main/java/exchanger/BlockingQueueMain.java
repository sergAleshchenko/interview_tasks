package exchanger;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueMain {
    public static void main(String[] args) {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(5);

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
//                    queue.put("Java " + i);
//                    boolean flag = queue.offer("Java " + i);
                    queue.add("Java " + i);
                    System.out.println("Element index " + i + " added ");
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
//                    System.out.println("Element " + queue.take() + " took");
//                    System.out.println("Element " + queue.poll() + " polled");
                    System.out.println("Element " + queue.remove() + " removed");
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        try {
            TimeUnit.SECONDS.timedJoin(Thread.currentThread(), 5);
            System.out.println(queue);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
