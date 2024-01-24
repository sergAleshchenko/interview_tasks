package evgeny_borisov.spring_potroshitel;

import lombok.Setter;

/**
 * @author Sergei Aleshchenko
 */
public class TerminatorQuoter implements Quoter {
    @Setter
    private String message;

    @Override
    public void sayQuote() {
        System.out.println("message = " + message);
    }
}
