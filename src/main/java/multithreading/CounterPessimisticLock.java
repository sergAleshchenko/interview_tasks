package multithreading;

/**
 * @author Sergei Aleshchenko
 */
public class CounterPessimisticLock {

    private int count;

    public int incrementAndGet() {
        synchronized (this) {
            count += 1;
            return count;
        }
    }

    public int get() {
        synchronized (this) {
            return count;
        }
    }
}
