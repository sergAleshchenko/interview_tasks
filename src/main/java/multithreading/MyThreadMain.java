package multithreading;


class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Shut down hook task completed");
    }
}

public class MyThreadMain {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new MyThread());
        System.out.println("Now main sleeping... press CTRL+C to exit");

        try {
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
