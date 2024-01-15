package logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Sergei Aleshchenko
 */
public class AnotherClass {
    private static Logger logger = LogManager.getLogger();

    public void testMethod() {
        logger.log(Level.FATAL, "Fatal event");
        logger.log(Level.INFO, "Info event");
    }
}
