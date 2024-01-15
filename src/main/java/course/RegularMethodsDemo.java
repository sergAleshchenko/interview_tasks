package course;

import java.util.Arrays;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class RegularMethodsDemo {
    public static void main(String[] args) {
        String a = "Hello34523453there45454345hey";

        String[] words = a.split("\\d+");
        System.out.println(Arrays.toString(words));

        String b = "Hello345 23453there454 54345hey";
        String replaced = b.replaceAll("\\d+", "-");
        System.out.println(replaced);


        String c = "Hello34523453there45454345hey";
        String modified = c.replaceFirst("\\d+", "-");
        System.out.println(modified);


    }
}
