package akvelon;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Sergei Aleshchenko
 */
public class BalancedBrackets {

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            //Complete the code
            System.out.println(isBalanced(input));
        }

    }


    public static boolean isBalanced(String input) {
        if(input == null) {
            return false;
        }

        if(input.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();


        for(Character c: input.toCharArray()) {
            switch(c) {
                case '(' :
                case '{' :
                case '[' :
                    stack.add(c);
                    break;
                case ')' :
                    if (stack.isEmpty() || !stack.pop().equals('('))
                        return false;
                    break;
                case '}' :
                    if (stack.isEmpty() || !stack.pop().equals('{'))
                        return false;
                    break;
                case ']' :
                    if (stack.isEmpty() || !stack.pop().equals('['))
                        return false;
                    break;
                default:
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
