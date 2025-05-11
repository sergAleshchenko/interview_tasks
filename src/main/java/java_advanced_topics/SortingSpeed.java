package java_advanced_topics;

import java.util.*;

/**
 * @author Sergei Aleshchenko
 */
public class SortingSpeed {


    public static void main(String[] args) {
        Random random = new Random();
        List<Book> arrayList = new ArrayList<>();
        LinkedList<Book> linkedList = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
//            arrayList.add(new Book(i, "test" + random.nextInt(2000000), "test" + i));
            linkedList.add(new Book(i, "test" + random.nextInt(2000000), "test" + i));
        }

        long start = System.currentTimeMillis();
//        Collections.sort(arrayList, new TitleComparator());
        Collections.sort(linkedList, new ReverseTitleComparator());



        long end = System.currentTimeMillis();

//        System.out.println("ArrayList: " + (end - start));
        System.out.println("LinkedList: " + (end - start));

    }

}


