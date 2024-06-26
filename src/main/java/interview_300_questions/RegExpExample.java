package interview_300_questions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sergei Aleshchenko
 */
public class RegExpExample {
    public static void main(String[] args) {
        String examplePass = "asdf12345";

        String passRegex = "^[a-zA-Z][a-zA-Z0-9]{8,19}";

        Pattern compile = Pattern.compile(passRegex);
        Matcher matcher = compile.matcher(examplePass);
        boolean isOk = matcher.matches();

        System.out.println(isOk);
    }
}
