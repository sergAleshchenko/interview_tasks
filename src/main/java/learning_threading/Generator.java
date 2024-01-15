package learning_threading;

/**
 * @author Sergei Aleshchenko
 */
public class Generator {
    public static void main(String[] args) {
        EvenNumberHolder holder = new EvenNumberHolder();
        EvenTask task = new EvenTask(holder);

        for (int i = 0; i < 15; i++) {
            new Thread(task).start();
        }
    }
}
