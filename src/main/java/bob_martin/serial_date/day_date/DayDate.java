package bob_martin.serial_date.day_date;

import java.io.Serializable;

/**
 * @author Sergei Aleshchenko
 */
public abstract class DayDate implements Comparable, Serializable {

    public abstract int getOrdinalDay();

    public abstract int getYear();

    public abstract Month getMonth();

    public abstract int getDayOfMonth();

}
