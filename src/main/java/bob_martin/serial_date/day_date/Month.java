package bob_martin.serial_date.day_date;

import java.text.DateFormatSymbols;

/**
 * @author Sergei Aleshchenko
 */
public enum Month {
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);

    private static DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
    private static final int[] LAST_DAY_OF_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int index;

    Month(int index) {
        this.index = index;
    }

    public static Month fromInt(int monthIndex) {
        for (Month m : Month.values()) {
            if (m.index == monthIndex) {
                return m;
            }
        }
        throw new IllegalArgumentException("Invalid month index: " + monthIndex);
    }

    public int lastDay() {
        return LAST_DAY_OF_MONTH[index];
    }

    public int quarter() {
        return 1 + (index - 1) / 3;
    }

}
