package others;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatDemo {

    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.GERMAN);
        String source = "1.234,567";
        NumberFormat numberFormatUs = NumberFormat.getInstance(Locale.US);
        NumberFormat numberFormatFr = NumberFormat.getInstance(Locale.FRANCE);


        try {
            double number = numberFormat.parse(source).doubleValue();
            System.out.println(number);
            String formatUS = numberFormatUs.format(number);
            String formatFR = numberFormatFr.format(number);

            System.out.println("US " + formatUS);
            System.out.println("FR " + formatFR);

            double numberUS = numberFormatUs.parse(source).doubleValue();
            double numberFR = numberFormatFr.parse(source).doubleValue();

            System.out.println("US(parse) " + numberUS);
            System.out.println("FR(parse) " + numberFR);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
