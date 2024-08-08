package multithreading;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PointLockMain {
    public static void main(String[] args) {
        PointManager pointManager = new PointManager();
        Random rand = new Random();

        ExecutorService service = Executors.newFixedThreadPool(15);

        for (int i = 0; i < 15; i++) {
            service.submit(new PointThread(pointManager, new Point(1, -1), rand.nextBoolean()));
        }
        service.shutdown();
    }
}
