package java_advanced_topics;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Sergei Aleshchenko
 */
public class MapsSpeed {

    public static void main(String[] args) {
        Random random = new Random();
        Map<Integer, Book> hashMap = new HashMap<>();
        Map<Integer, Book> linkedHashMap = new LinkedHashMap<>();

        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            hashMap.put(random.nextInt(1000000),
                    new Book(i, "test" + random.nextInt(2000000), "test" + i));

//            linkedHashMap.put(random.nextInt(1000000),
//                    new Book(i, "test" + random.nextInt(2000000), "test" + i));
        }

        long end = System.currentTimeMillis();

        System.out.println("HashMap: " + (end - start));
//        System.out.println("LinkedHashMap: " + (end - start));

    }
}
