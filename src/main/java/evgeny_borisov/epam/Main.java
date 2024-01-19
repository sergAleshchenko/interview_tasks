package evgeny_borisov.epam;

/**
 * @author Sergei Aleshchenko
 */
public class Main {
    public static void main(String[] args) {
        CoronaDesinfector desinfector =
                ObjectFactory.getInstance().createObject(CoronaDesinfector.class);

        desinfector.start(new Room());
    }
}
