package multithreading;

/**
 * @author Sergei Aleshchenko
 */
public class ThreadGroupDemo implements Runnable {


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        ThreadGroupDemo runnable = new ThreadGroupDemo();

        ThreadGroup tg1 = new ThreadGroup("Parent ThreadGroup");

        Thread t1 = new Thread(tg1, runnable, "one");
        Thread t2 = new Thread(tg1, runnable, "two");
        Thread t3 = new Thread(tg1, runnable, "three");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Thread Group Name: " + tg1.getName());
        tg1.list();
    }
}
