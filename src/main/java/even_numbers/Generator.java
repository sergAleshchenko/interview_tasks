package even_numbers;;

/**
 * @author Sergei Aleshchenko
 */
public class Generator {
    public static void main(String[] args) {
        EvenNumberHolder evenNumberHolder = new EvenNumberHolder();

        EvenTask evenTask = new EvenTask(evenNumberHolder);

        for (int i = 0; i < 15; i++) {
            new Thread(evenTask).start();
        }
    }
}
