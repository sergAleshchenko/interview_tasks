package multithreading_interview;

/**
 * @author Sergei Aleshchenko
 */
public class MultithreadingDemo extends Thread {

    @Override
    public void run() {
        System.out.println("My thread is in running state.");
    }

    public static void main(String[] args) {
        MultithreadingDemo obj = new MultithreadingDemo();
        obj.start();

        MultithreadingDemo2 obj2 = new MultithreadingDemo2();
        Thread thread = new Thread(obj2);
        thread.start();
    }
}

class MultithreadingDemo2 implements Runnable {

    @Override
    public void run() {
        System.out.println("My second thread is in running state.");
    }
}
