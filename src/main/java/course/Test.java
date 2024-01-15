package course;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();

        measureTime(linkedList);
        measureTime(arrayList);
    }

    private static void measureTime(List<Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
//            list.add(0, i);
            list.add(i);
        }


        long end = System.currentTimeMillis();
        if (list.getClass().equals(LinkedList.class)) {
            System.out.println("Linked List: " + (end - start));
        } else if (list.getClass().equals(ArrayList.class)) {
            System.out.println("Array List: " + (end - start));
        }
    }
}
