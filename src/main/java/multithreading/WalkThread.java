package multithreading;

import java.util.concurrent.TimeUnit;

public class WalkThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println("Walk " + i);
                TimeUnit.MILLISECONDS.sleep(70);
            }
        } catch(InterruptedException e){
            throw new RuntimeException(e);
        } finally {
            System.out.println("End of WalkThread");
        }
    }
}
