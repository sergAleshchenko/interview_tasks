package others;

import java.util.*;

public class OrderDemo {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Map<String, Integer> hashtable = new Hashtable<>();
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<String, Integer> treeMap = new TreeMap<>();

        hashMap.put("three", 3);
        hashMap.put("one", 1);
        hashMap.put("four", 4);
        hashMap.put("two", 2);
        System.out.println("hashmap: " + hashMap);

        linkedHashSet.add("four");
        linkedHashSet.add("three");
        linkedHashSet.add("one");
        linkedHashSet.add("two");
        System.out.println("linkedHashSet: " + linkedHashSet);


        hashtable.put("two", 2);
        hashtable.put("one", 1);
        hashtable.put("four", 4);
        hashtable.put("three", 3);
        System.out.println("hashtable: " + hashtable);

        linkedHashMap.put("two", 2);
        linkedHashMap.put("one", 1);
        linkedHashMap.put("four", 4);
        linkedHashMap.put("three", 3);
        System.out.println("linkedHashMap: " + linkedHashMap);

        treeMap.put("four", 4);
        treeMap.put("three", 3);
        treeMap.put("two", 2);
        treeMap.put("one", 1);
        System.out.println("treeMap: " + treeMap);

        Map<String, Object> m1 = new HashMap<>();
        m1.put("k1","s");
        Map<String, Object> m2 = new HashMap<>(m1);
        m1.put("k2", m2);
        Map<String, Object> m3 = new HashMap<>(m1);
        m2.put("k2",m3);
        m1.put("k3",m2);
        System.out.print(m1);
    }
}
