package evgeny_borisov.epam;

/**
 * @author Sergei Aleshchenko
 */
public class Main {
    public static void main(String[] args) {
        CoronaDesinfector desinfector = new CoronaDesinfector();
        desinfector.start(new Room());
    }
}
