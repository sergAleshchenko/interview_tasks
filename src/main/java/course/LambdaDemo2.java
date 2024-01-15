package course;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class LambdaDemo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Hello");
        list.add("Goodbye");

        list.add("a");
        list.add("ab");

//        list.sort((o1, o2) -> {
//            if (o1.length() > o2.length()) {
//                return 1;
//            } else if (o1.length() < o2.length()) {
//                return -1;
//            } else {
//                return 0;
//            }
//        });

        Comparator<String> comparator = Comparator.comparingInt(String::length);

        list.sort(comparator);

        System.out.println(list);
    }
}
