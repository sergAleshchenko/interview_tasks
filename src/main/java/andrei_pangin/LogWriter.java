package andrei_pangin;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.security.PrivilegedAction;
import java.util.Collections;

/**
 * @author Sergei Aleshchenko
 */
public class LogWriter {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream(
                "H:\\IDEA_PROJECTS\\Learning\\src\\main\\java\\andrei_pangin\\tmp.txt");

        Exception cause = new Exception();

//        for (; ; ) {
//            AccessController.doPrivileged((PrivilegedAction<Object>) () -> {
//                new Exception(cause).printStackTrace(ps);
//                return null;
//            });
//        }
    }
}
