package patterns.abstract_factory;

/**
 * @author Sergei Aleshchenko
 */
public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created WindowsButton");
    }
}
