package course;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(77);
        list.add(1);

        Iterator<Integer> iterator = list.iterator();

        int idx = 0;
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

            if (idx == 1) {
                iterator.remove();
            }

            idx++;
        }

        System.out.println(list);

//        for (int x : list) {
//            list.remove(1);
//            System.out.println(x);
//        }
    }
}
