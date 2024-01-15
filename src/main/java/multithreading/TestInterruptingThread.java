package multithreading;

public class TestInterruptingThread extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                System.out.println("Task");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted..." + e);
        }
    }

    public static void main(String[] args) {
        TestInterruptingThread t1 = new TestInterruptingThread();
        t1.start();

        try {
            Thread.sleep(5000);
            t1.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
