package multithreading;

import java.util.concurrent.TimeUnit;

public class TalkThread implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println("Talk -->" + i);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch(InterruptedException e){
            throw new RuntimeException(e);
        } finally{
            System.out.println("End of TalkThread");
        }

    }
}
