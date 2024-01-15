package others;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList() {
            {
                this.offer("Jeans");
            }
        };

        queue.add("Dress");
        queue.offer("T-Shirt");

//        queue.removeIf(s -> s.endsWith("t"));
//        queue.forEach(System.out::println);

        queue.stream().filter(s -> !s.endsWith("t")).forEach(System.out::println);
        System.out.println();
        queue.forEach(System.out::println);

//        queue.forEach(System.out::println);
//        System.out.println();
//        queue.remove("Dress");
//        queue.forEach(System.out::println);
//        System.out.println();
//        queue.clear();
//        queue.element();

        String s1 = new String("Welcome");
        String s2 = new String("Welcome");

        System.out.println(s1 == s2);

        String s3 = "Welcome";

        System.out.println(s3 == s1);
        System.out.println(s3 == s2);

        String s4 = "Welcome";

        System.out.println(s3 == s4);
    }
}
