package evgeny_borisov.spring_potroshitel.part_1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Sergei Aleshchenko
 */
public class PropertyFileApplicationContext {
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
