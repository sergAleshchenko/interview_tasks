package patterns.strategy.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Sergei Aleshchenko
 */
public class PayByCreditCard implements PayStrategy {

    private final BufferedReader READER =
            new BufferedReader(new InputStreamReader(System.in));
    private CreditCard creditCard;

    @Override
    public void collectPaymentDetails() {
        try {
            System.out.println("Enter the card number: ");
            String number = READER.readLine();
            System.out.println("Enter the card expiration date 'mm/yy': ");
            String date = READER.readLine();
            System.out.println("Enter the CVV code: ");
            String cvv = READER.readLine();
            creditCard = new CreditCard(number, date, cvv);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (cardIsPresent()) {
            System.out.println("Paying " + paymentAmount + " using Credit Card");
            creditCard.setAmount(creditCard.getAmount() - paymentAmount);
            return true;
        } else {
            return false;
        }
    }

    private boolean cardIsPresent() {
        return creditCard != null;
    }
}
