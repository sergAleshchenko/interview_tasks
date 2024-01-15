package patterns.observer.listeners;

import java.io.File;

/**
 * @author Sergei Aleshchenko
 */
public interface EventListener {
    void update(String eventType, File file);
}
