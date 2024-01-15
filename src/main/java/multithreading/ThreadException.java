package multithreading;

import java.util.concurrent.TimeUnit;

public class ThreadException {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("End of Exception Thread");
        }).start();

        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (Boolean.TRUE) {
            throw new RuntimeException();
        }

        System.out.println("End of main");
    }
}
