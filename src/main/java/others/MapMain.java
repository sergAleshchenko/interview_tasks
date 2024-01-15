package others;

import java.util.*;

public class MapMain {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("T-Shirt", 5);
        map.put("Jeans", 5);
        map.put("Gloves", 5);

        System.out.println(map);

//        Integer value = map.put("Jeans", 4);
//        System.out.println(map);
//        System.out.println(value);

        Set<String> set = map.keySet();
        System.out.println(set);

        Collection<Integer> collection = map.values();
        Set<Integer> sets = new HashSet<>(collection);

        System.out.println(collection);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println(entries);
        System.out.println(sets);


    }
}
