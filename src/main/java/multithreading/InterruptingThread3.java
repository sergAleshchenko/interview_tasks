package multithreading;

public class InterruptingThread3 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + 1);
        }
    }


    public static void main(String[] args) {
        InterruptingThread3 t1 = new InterruptingThread3();
        t1.start();

        t1.interrupt();
    }
}
