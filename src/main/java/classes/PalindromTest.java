package classes;


/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class PalindromTest {
    public static void main(String[] args) {
        String test = "Some string . 2345 && asdf";
        String trim = test.trim().toLowerCase();
    }

    public static boolean isPalindrome(String trimmedString) {

        boolean result = true;
        char[] chars = trimmedString.toCharArray();
        int i = 0;
        int j = chars.length;

        while (i <= j) {
            if (chars[i] != chars[j - 1]) {
                result = false;
                break;
            }
            i++;
            j--;
        }

        return result;
    }
}
