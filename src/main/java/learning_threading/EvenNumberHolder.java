package learning_threading;

/**
 * @author Sergei Aleshchenko
 */
public class EvenNumberHolder {
    private int currentEven = 0;

    public int getNextEven() {
        synchronized (this) {
            currentEven++;
            currentEven++;
        }
        return currentEven;
    }
}
