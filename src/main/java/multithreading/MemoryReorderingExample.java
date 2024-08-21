package multithreading;

import lombok.Getter;

/**
 * @author Sergei Aleshchenko
 */
@Getter
public class MemoryReorderingExample {

    private int x;
    private int y;

    public int T1() {
        x = 1;
        int r1 = y;

        return r1;
    }

    public int T2() {
        y = 1;
        int r2 = x;

        return r2;
    }


    public static void main(String[] args) {
        Thread thread1 = new Thread(new Executor1());
        Thread thread2 = new Thread(new Executor2());
        thread1.start();
        thread2.start();
    }

}

class Executor1 implements Runnable {

    @Override
    public void run() {
        MemoryReorderingExample mr = new MemoryReorderingExample();
        System.out.println(mr.T1() + " " + mr.getX());
    }
}

class Executor2 implements Runnable {

    @Override
    public void run() {
        MemoryReorderingExample mr = new MemoryReorderingExample();
        System.out.println(mr.T2() + " " + mr.getY());
    }
}
