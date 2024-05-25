package interview_questions_300;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Sergei Aleshchenko
 */
public class FindDayDemo {
    public static String findDay(int month, int day, int year) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");

        calendar.set(year, month - 1, day);

        return dateFormat.format(calendar.getTime()).toUpperCase();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);
        int day = Integer.parseInt(firstMultipleInput[1]);
        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = FindDayDemo.findDay(month, day, year);

        System.out.println(res);
    }
}
