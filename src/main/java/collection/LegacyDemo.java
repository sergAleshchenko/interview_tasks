package collection;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

public class LegacyDemo {
    public static void main(String[] args) {
        Hashtable<String, Integer> table = new Hashtable<>();
        table.put("Jeans", 40);
        table.put("T-Shirt", 35);
        table.put("Gloves", 42);
        table.compute("Shoes", (s, integer) -> 77);

        table.compute("Shoes", (s, integer) -> integer + s.length());
        table.computeIfAbsent("Shoes", s -> 11);


        Enumeration<String> keys = table.keys();
        while (keys.hasMoreElements()) {
            System.out.println(keys.nextElement());
        }

        System.out.println();

        Enumeration<Integer> elements = table.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }

        System.out.println(table);
    }
}
