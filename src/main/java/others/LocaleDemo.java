package others;

import java.util.Locale;

public class LocaleDemo {

    public static void main(String[] args) {
        Locale locale = Locale.FRANCE;
        Locale locale1 = Locale.getDefault();
        Locale locale2 = new Locale("be");
        Locale locale3 = new Locale("be", "BY");

        System.out.println(locale + " " + locale1 + " " + locale2 + " " + locale3);

        Locale.setDefault(locale3);
        System.out.println(Locale.getDefault());
    }
}
