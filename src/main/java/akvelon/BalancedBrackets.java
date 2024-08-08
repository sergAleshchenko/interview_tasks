package akvelon;

import java.util.Stack;

/**
 * @author Sergei Aleshchenko
 */
public class BalancedBrackets {
    private Stack<Character> stack = new Stack<>();

    // array mem => O(n)
    // stack mem => O(1)
    // cpu => O(n)
    public boolean isBalanced(String s) {
        boolean result = false;

        // null and empty string case
        if (s == null) {
            return false;
        } else if (s.length() == 0) {
            return true;
        }

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            switch (chars[i]) {
                case ')': {
                    char poppedBracket = ' ';
                    if (!stack.isEmpty()) {
                        poppedBracket = stack.pop();
                        if (poppedBracket == '(') {
                            return true;
                        }
                    } else {
                        result = false;
                    }
                    break;
                }
                case ']': {
                    char poppedBracket = ' ';
                    if (!stack.isEmpty()) {
                        poppedBracket = stack.pop();
                        if (poppedBracket == '[') {
                            return true;
                        }
                    } else {
                        result = false;
                    }
                    break;
                }
                case '}': {
                    char poppedBracket = ' ';
                    if (!stack.isEmpty()) {
                        poppedBracket = stack.pop();
                        if (poppedBracket == '{') {
                            return true;
                        }
                    } else {
                        result = false;
                    }
                    break;
                }
            }

            // (1+6) case
            if (chars[i] == ')' || chars[i] == ']' || chars[i] == '}' ||
                    chars[i] == '(' ||chars[i] == '[' ||chars[i] == '{') {
                stack.push(chars[i]);
            }
        }

        return result;
    }

}
