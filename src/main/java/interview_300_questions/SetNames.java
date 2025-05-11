package interview_300_questions;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Sergei Aleshchenko
 */
public class SetNames {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        int result = uniqueNames(pair_left, pair_right);
        System.out.println(result);


    }

    public static int uniqueNames(String[] pairLeft, String[] pairRight) {
        Set<String> names = new HashSet<>();
        int unique = 0;
        int curSize = 0;


        for (int i = 0; i < pairLeft.length; i++) {
            curSize = names.size();
            names.add(pairLeft[i] + " " + pairRight[i]);
            if(curSize != names.size()) {
                unique++;
            }
            System.out.println(unique);
        }
        return unique;
    }
}
