package others;

import java.util.HashSet;
import java.util.Set;

public class SetMain {

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>() {
            {
                this.add("one");
                this.add("two");
                this.add("three");
            }
        };

        boolean value = set.add("three");

        System.out.println(set + " " + value);
    }
}
