package patterns.factory_method;

/**
 * @author Sergei Aleshchenko
 */
public abstract class Dialog {

    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    public abstract Button createButton();
}
