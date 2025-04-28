package interview_300_questions;

import java.util.Scanner;

/**
 * @author Sergei Aleshchenko
 */
public class SmallestAndLargestSubstrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));

        System.out.println("".compareTo("wel"));
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = smallest;

        for(int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);

            if(sub.compareTo(smallest) <= 0) {
                smallest = sub;
            }

            if(sub.compareTo(largest) >= 0) {
                largest = sub;
            }

        }


        return smallest + "\n" + largest;
    }
}
