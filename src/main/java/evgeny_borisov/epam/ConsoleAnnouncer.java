package evgeny_borisov.epam;

/**
 * @author Sergei Aleshchenko
 */
public class ConsoleAnnouncer implements Announcer {
    private Recommendator recommendator =
            ObjectFactory.getInstance().createObject(Recommendator.class);
    @Override
    public void announce(String message) {
        System.out.println(message);
        recommendator.recommend();
    }
}
