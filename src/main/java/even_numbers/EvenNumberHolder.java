package even_numbers;

/**
 * @author Sergei Aleshchenko
 */
public class EvenNumberHolder {

    private int currentEven = 0;

    public int getNextEven() {
        synchronized (this) {
            currentEven = currentEven + 2;
        }
        return currentEven;
    }
}
