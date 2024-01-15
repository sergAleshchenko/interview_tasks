package patterns.memento.commands;

/**
 * @author Sergei Aleshchenko
 */
public interface Command {
    String getName();
    void execute();
}
