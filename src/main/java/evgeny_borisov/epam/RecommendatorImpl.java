package evgeny_borisov.epam;

/**
 * @author Sergei Aleshchenko
 */

@Singleton
public class RecommendatorImpl implements Recommendator {
    @InjectProperty("whiskey")
    private String alcohol;

    @Override
    public void recommend() {
        System.out.println("to protect from covid-2019, drink " + alcohol);
    }
}
