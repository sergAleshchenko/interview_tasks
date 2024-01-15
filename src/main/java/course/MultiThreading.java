package course;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class MultiThreading {
    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread = new MyThread("myThread1");
//        MyThread myThread2 = new MyThread("myThread2");

//        myThread.start();
//        myThread2.start();

        Thread runner1 = new Thread(new Runner("Runner1"));
        runner1.start();

        System.out.println("Hello from main thread");
    }

}

class Runner implements Runnable {

    private String threadName;

    public Runner(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000l; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Hello from MyThread " + threadName + " " + i);
        }
    }
}

class MyThread extends Thread {
    private String threadName;

    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000l; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Hello from MyThread " + threadName + " " + i);
        }
    }
}
