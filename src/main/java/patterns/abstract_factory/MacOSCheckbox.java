package patterns.abstract_factory;

/**
 * @author Sergei Aleshchenko
 */
public class MacOSCheckbox implements CheckBox {
    @Override
    public void paint() {
        System.out.println("You have create MacOSCheckbox");
    }
}
