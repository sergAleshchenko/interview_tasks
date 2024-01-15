package logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Sergei Aleshchenko
 */
public class Main {
    private static Logger logger = LogManager.getLogger();


    public static void main(String[] args) {
        logger.log(Level.ERROR, "Error event");
        logger.trace("Trace event");
        logger.info("Info event");

        AnotherClass anotherClass = new AnotherClass();
        anotherClass.testMethod();
    }
}
