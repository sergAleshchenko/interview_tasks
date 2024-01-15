package patterns.abstract_factory;

/**
 * @author Sergei Aleshchenko
 */
public class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created MacOSButton");
    }
}
