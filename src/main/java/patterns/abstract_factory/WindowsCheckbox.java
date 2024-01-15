package patterns.abstract_factory;

/**
 * @author Sergei Aleshchenko
 */
public class WindowsCheckbox implements CheckBox {
    @Override
    public void paint() {
        System.out.println("You have created WindowCheckbox");
    }
}
