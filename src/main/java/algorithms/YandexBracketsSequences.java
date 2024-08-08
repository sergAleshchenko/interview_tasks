package algorithms;

/**
 * @author Sergei Aleshchenko
 */
public class YandexBracketsSequences {
    static void printParenthesis(char str[], int cur, int n, int open, int close) {
        if (close == n) {
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i]);
            }
            System.out.println();
        } else {
            if (open < n) {
                str[cur] = '(';
                printParenthesis(str, cur + 1, n, open + 1, close);
            }

            if (open > close) {
                str[cur] = ')';
                printParenthesis(str, cur + 1, n, open, close + 1);
            }
        }
    }


    static void printParenthesis(char str[], int n) {
        if (n > 0) {
            printParenthesis(str, 0, n, 0, 0);
        }
    }


    public static void main(String[] args) {
        int n = 4;
        char[] str = new char[2 * n];
        printParenthesis(str, n);
    }
}
