package evgeny_borisov.epam;

/**
 * @author Sergei Aleshchenko
 */
public class ConsoleAnnouncer implements Announcer {
    @Override
    public void announce(String message) {
        System.out.println(message);
    }
}
