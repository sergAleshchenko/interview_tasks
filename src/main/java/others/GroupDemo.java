package others;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupDemo {
    public static void main(String[] args) {
        String input = "java";
        String regex = "(([a-z]*)([a-z]+))";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            System.out.println("main group: " + matcher.group());
            System.out.println("group 1: " + matcher.group(1));
            System.out.println("group 2: " + matcher.group(2));
            System.out.println("group 3: " + matcher.group(3));
//            System.out.println("group 4: " + matcher.group(4));
//            System.out.println("group 2: " + matcher.group(5));
        } else {
            System.out.println("nothing");
        }
        System.out.println(matcher.groupCount());
    }
}
