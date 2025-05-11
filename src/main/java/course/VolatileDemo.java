package course;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class VolatileDemo {
    public static void main(String[] args) {
        MyThreadVol myThreadVol = new MyThreadVol();
        myThreadVol.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();


        myThreadVol.shutdown();
    }
}

class MyThreadVol extends Thread {
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}
