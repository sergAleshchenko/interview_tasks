package others;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {

    public static void main(String[] args) {
        Locale locale = new Locale("be", "BY");
        ResourceBundle bundle = ResourceBundle.getBundle("res.message", locale);
        String s1 = bundle.getString("str1");
        String s2 = bundle.getString("str2");

        System.out.println(s1);
        System.out.println(s2);

        System.out.println(bundle.keySet());


    }
}
