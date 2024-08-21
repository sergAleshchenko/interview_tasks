package multithreading;

/**
 * @author Sergei Aleshchenko
 */
public class MultithreadingDemo3 {

    public static void main(String[] args) {
        SomeThread someThread = new SomeThread();
        someThread.start();

        Thread someThread2 = new Thread(new SomeThread2());
        someThread2.start();
    }

}

class SomeThread extends Thread {
    @Override
    public void run() {
        System.out.println("SomeThread.run() running...");
    }
}

class SomeThread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("SomeThread2.run() running...");
    }
}
