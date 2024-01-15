package learning_threading;

/**
 * @author Sergei Aleshchenko
 */
public class EvenTask implements Runnable {

    private EvenNumberHolder evenNumberHolder;

    public EvenTask(EvenNumberHolder evenNumberHolder) {
        this.evenNumberHolder = evenNumberHolder;
    }

    @Override
    public void run() {
        while (true) {
            int value = evenNumberHolder.getNextEven();
            System.out.println("Thread " + Thread.currentThread().getName() +
                    " has got the number " + value);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
