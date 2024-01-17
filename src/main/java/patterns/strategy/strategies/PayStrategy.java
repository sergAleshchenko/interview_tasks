package patterns.strategy.strategies;

/**
 * @author Sergei Aleshchenko
 */
public interface PayStrategy {


    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
