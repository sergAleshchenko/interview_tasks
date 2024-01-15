package collection;

import java.util.LinkedHashSet;

/**
 * @author Sergei Aleshchenko
 */
public class CollectionExample {
    public static void main(String[] args) {
        LinkedHashSet<String> positions = new LinkedHashSet<>();
        positions.add("junior");
        positions.add("junior");
        positions.add("middle");
        positions.add("senior");
        positions.add("team lead");
        positions.add("architect");
        System.out.println(positions);

    }
}
