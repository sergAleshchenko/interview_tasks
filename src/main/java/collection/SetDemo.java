package collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedHashSet;

/**
 * @author Sergei Aleshchenko
 */
public class SetDemo {
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
