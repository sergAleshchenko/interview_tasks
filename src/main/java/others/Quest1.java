package others;

import java.util.NavigableMap;
import java.util.TreeMap;

public class Quest1 {
    public static void main(String[] args) {
        NavigableMap<String, Number> nmap = new TreeMap<>();

        nmap.put("one", new Integer(1));
        nmap.put("two", new Integer(2));
        nmap.put("three", new Integer(3));
        nmap.put("four", new Integer(4));

        System.out.println(nmap);

        System.out.println(nmap.headMap("three"));

    }
}
