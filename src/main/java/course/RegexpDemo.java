package course;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class RegexpDemo {
    public static void main(String[] args) {

        /*
            \\d - one digit
            \\w - one letter. The same as [a-zA-Z]

            + - 1 or more
            * - 0 or more
            ? - 0 or 1 digits before

            (x|y|z) - one string from the set of strings
            [abc] = (a|b|c)
            [a-zA-Z] - all English letters
            [0-9] - all digits
            [^abc] - all characters except [abc]
            . - any symbol

            {2} - 2 symbols before (\\d{2})
            {2,} - 2 or more symbols (\\d{2,})
            {2, 4} - from 2 to 4 symbols (\\d{2,4})

         */

        String a = "-3434";
        String b = "1234123";
        String c = "+1234123";

        System.out.println(a.matches("-?\\d*"));
        System.out.println(b.matches("-?\\d*"));
        System.out.println(c.matches("-?\\d*"));

        System.out.println("------------------------------------");

        System.out.println(a.matches("(-|\\+)?\\d*"));
        System.out.println(b.matches("(-|\\+)?\\d*"));
        System.out.println(c.matches("(-|\\+)?\\d*"));

        System.out.println("------------------------------------");


        String d = "gdfdd33311fd11f12345454";
        System.out.println(d.matches("[a-zA-Z31]+\\d+"));

        System.out.println("------------------------------------");

        String e = "heallo";
        System.out.println(e.matches("[^abc]*"));

        System.out.println("------------------------------------");

        String url = "http://www.google.com";
        String url2 = "http://www.yandex.ru";
        String url3 = "Hello there!";
        System.out.println(url.matches("http://www\\..+\\.(com|ru)"));
        System.out.println(url2.matches("http://www\\..+\\.(com|ru)"));
        System.out.println(url3.matches("http://www\\..+\\.(com|ru)"));

        System.out.println("------------------------------------");

        String f = "1454";
        System.out.println(f.matches("\\d{2,}"));
    }
}
