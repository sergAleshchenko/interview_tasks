package interview_300_questions;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Sergei Aleshchenko
 */
public class CurrencySolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        String us = formatCurrency(payment, Locale.US);
        String india = formatCurrency(payment, new Locale("en", "IN"));
        String china = formatCurrency(payment, Locale.CHINA);
        String france = formatCurrency(payment, Locale.FRANCE);


        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }

    private static String formatCurrency(double amount, Locale locale) {
        "asdf".compareTo("sadf");
        return NumberFormat.getCurrencyInstance(locale).format(amount);
    }
}
