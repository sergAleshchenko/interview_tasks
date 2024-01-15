package multithreading;

import java.util.concurrent.TimeUnit;

public class SynchroBlockMain {
    static int counter;

    public static void main(String[] args) {
//        StringBuilder info = new StringBuilder();
        StringBuffer info = new StringBuffer();

        new Thread(() -> {
            synchronized (info) {
                do {
                    info.append('A');
                    System.out.println(info);
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } while (counter++ < 6);
            }
        }).start();

//        synchronized (info) {
            while (counter++ < 3) {
                info.append('Z');
                System.out.println(info);
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
//            }
        }

    }
}
