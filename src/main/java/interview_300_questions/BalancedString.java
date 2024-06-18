package interview_300_questions;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Sergei Aleshchenko
 */
public class BalancedString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> chars = new Stack<>();

        while (sc.hasNext()) {
            String input=sc.next();
            boolean flag = true;

            //Complete the code

            for (int i = 0; i < input.length(); i++) {

                char current = input.charAt(i);
                if(current == '{' || current == '(' || current == '[') {
                    chars.push(current);
                } else {
                    if(current == '}' && chars.pop() != '{') flag = false;
                    if(current == ')' && chars.pop() != '(') flag = false;
                    if(current == ']' && chars.pop() != '[') flag = false;
                }

            }

            if(chars.size() != 0) {
                flag = false;
                chars.clear();
            };
            System.out.println(flag);
        }
    }
}
