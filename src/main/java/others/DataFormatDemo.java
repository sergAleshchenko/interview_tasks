package others;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class DataFormatDemo {
    public static void main(String[] args) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM, new Locale("us", "US"));
//        String dateStr = dateFormat.format(new Date())
//        System.out.println(dateStr);


        try {
            Date date = dateFormat.parse("2023 Sep 30, Sat 16:52:22");
            System.out.println(date);

            DateFormat dateFormatCa = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.CANADA);
            System.out.println(dateFormatCa.format(date));

            DateFormat dateFormatFr = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.FRANCE);
            System.out.println(dateFormatFr.format(date));


        } catch (ParseException e) {
            throw new RuntimeException(e);
        }




    }
}
