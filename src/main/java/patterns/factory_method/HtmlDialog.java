package patterns.factory_method;

/**
 * @author Sergei Aleshchenko
 */
public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
