package evgeny_borisov.spring_patterns.for_adult;

/**
 * @author Sergei Aleshchenko
 */
public interface Целитель {
    void исцелять(Patient patient);

    String ТРАДИЦИОННАЯ = "traditional";
    String НАРОДНАЯ = "folk";
}
