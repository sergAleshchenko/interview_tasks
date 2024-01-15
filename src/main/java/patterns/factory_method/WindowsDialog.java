package patterns.factory_method;

/**
 * @author Sergei Aleshchenko
 */
public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
