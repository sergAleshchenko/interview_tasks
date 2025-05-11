package others;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.regex.Matcher;

public class PriorityMain {
    public static void main(String[] args) {
        Queue<String> prior = new PriorityQueue<>(Comparator.reverseOrder());
        prior.offer("J");
        prior.offer("A");
        prior.offer("V");
        prior.offer("A");
        prior.offer("2");

//        while (!prior.isEmpty()) {
//            System.out.println(prior.poll());
//        }


        String s1 = "Sharma is a good player";
        String s2 = new String("Sharma is a good player");
        s2 = s2.intern();
        System.out.println(s1 == s2);


    }
}
