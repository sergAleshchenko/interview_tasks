package evgeny_borisov.spring_puzzlers.part_1;

/**
 * @author Sergei Aleshchenko
 */
public interface JokerConfService {
    void pay();
    void payTransactional();

    void informAboutPayment();

    void processPayment();
}
