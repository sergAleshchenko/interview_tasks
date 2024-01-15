package course;

import java.util.*;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class MapTest {
    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//
//        map.put("кошка", "cat");
//        map.put("собака", "dog");
//        map.put("слон", "elephant");
//        map.put("слон2", "elephant");
//        map.put(null, "elephant3");
//        map.put(null, "elephant4");
//
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }



        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();

        testMap(treeMap);

    }

    public static void testMap(Map<Integer, String> map) {
        map.put(39, "Bob");
        map.put(12, "Mike");
        map.put(78, "Tom");
        map.put(0, "Tim");
        map.put(1500, "Lewis");
        map.put(7, "Bob");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
