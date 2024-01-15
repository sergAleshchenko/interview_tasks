package course;

import java.util.*;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
//        Set<String> linkedHashSet = new LinkedHashSet<>();
//        Set<String> treeSet = new TreeSet<>();

        hashSet.add("Mike");
        hashSet.add("Katy");
        hashSet.add("Tom");
        hashSet.add("Bob");
        hashSet.add("George");

//        linkedHashSet.add("Mike");
//        linkedHashSet.add("Katy");
//        linkedHashSet.add("Tom");
//        linkedHashSet.add("Bob");
//        linkedHashSet.add("George");
//
//        treeSet.add("Mike");
//        treeSet.add("Katy");
//        treeSet.add("Tom");
//        treeSet.add("Bob");
//        treeSet.add("George");


//        printSet(hashSet);
//        printSet(linkedHashSet);
//        printSet(treeSet);

        Set<Integer> set1 = new HashSet<>();
        set1.add(0);
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);

        // Union
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        System.out.println(union);

        // Intersection
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        System.out.println(intersection);

        // Difference
        Set<Integer> diff = new HashSet<>(set1);
        diff.removeAll(set2);

        System.out.println(diff);


    }

    public static void printSet(Set<String> set) {
        for (String name : set) {
            System.out.println(name);
        }
        System.out.println("-----------------------------");
    }

    private static void measureTime(Set<String> set) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            set.add(Integer.toString(i));
        }


        long end = System.currentTimeMillis();
        if (set.getClass().equals(HashSet.class)) {
            System.out.println("HashSet " + (end - start));
        } else if (set.getClass().equals(LinkedHashSet.class)) {
            System.out.println("LinkedHashSet " + (end - start));
        } else if (set.getClass().equals(TreeSet.class)) {
            System.out.println("TreeSet " + (end - start));
        }
    }
}
