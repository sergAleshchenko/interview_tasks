package collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorMain {
    public static void main(String[] args) {
        Vector<String> vct = new Vector<>();
        vct.add("One");
        vct.add("Two");
        vct.add("Three");
        vct.add("Four");
        vct.add("Five");
        vct.add("Six");
        Iterator itr = vct.iterator();
        vct.remove(0);
        System.out.println(itr.next());

        Vector<String> vector = new Vector<>();
        vector.add("java");
        vector.add("belarus");
        vector.add(1, null);
        vector.addAll(vector);
        vector.removeIf(e -> e == null);
        vector.replaceAll(String::toUpperCase);

        long count = vector.stream().count();
        System.out.println(count);
        System.out.println(vector);

        Enumeration<String> enumeration = vector.elements();

        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}
