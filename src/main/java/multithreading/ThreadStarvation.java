package multithreading;

/**
 * @author Sergei Aleshchenko
 */
public class ThreadStarvation {

    public static void main(String[] args) {
        System.out.println("Parent thread execution starts");

        Starvation thread1 = new Starvation();
        thread1.setPriority(7);

        Starvation thread2 = new Starvation();
        thread1.setPriority(6);

        Starvation thread3 = new Starvation();
        thread1.setPriority(5);


        Starvation thread4 = new Starvation();
        thread1.setPriority(4);

        Starvation thread5 = new Starvation();
        thread1.setPriority(3);

        thread1.run();
        thread2.run();
        thread3.run();
        thread4.run();
        thread5.run();

        System.out.println("Parent thread execution completes");
    }
}

class Starvation extends Thread {
    private static int count = 1;

    @Override
    public void run() {
        System.out.println(count + " Thread execution starts");
        System.out.println("Thread execution completes");
        count++;
    }
}
