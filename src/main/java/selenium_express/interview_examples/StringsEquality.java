package selenium_express.interview_examples;

/**
 * @author Sergei Aleshchenko
 */
public class StringsEquality {
    public static void main(String[] args) {
        String s1 = "100";
        Integer number = 100;

        String s2 = number.toString().intern();

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));


    }
}

