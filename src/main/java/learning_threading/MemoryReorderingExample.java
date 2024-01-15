package learning_threading;

/**
 * @author Sergei Aleshchenko
 */
public class MemoryReorderingExample {
    private int x;
    private int y;


    public void T1() {
        x = 1;
        int r1 = y;
    }

    public void T2() {
        y = 1;
        int r2 = x;
    }
}
