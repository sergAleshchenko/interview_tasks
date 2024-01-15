package patterns.observer;

import patterns.observer.editor.Editor;
import patterns.observer.listeners.EmailNotificationListener;
import patterns.observer.listeners.LogOpenListener;

/**
 * @author Sergei Aleshchenko
 */
public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open",
                new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save",
                new EmailNotificationListener("admin@example.com"));


        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
