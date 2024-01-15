package others;

import java.util.HashSet;
import java.util.TreeSet;

public class HashSetMain {
    public static void main(String[] args) {
        HashSet<String> words = new HashSet<>(1000);

        words.add("8Y1");
        words.add("2Y");
        words.add("asdf");
        words.add("8Y1");
        words.add("6Y");
        words.add("SSS");
        words.add("AAA");
        System.out.println(words);

        TreeSet<String> treeSet = new TreeSet<>(words);

        for (String element : words) {
            System.out.print(element.hashCode() + " ");
        }

//        System.out.println(treeSet);
    }
}
