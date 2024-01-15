package patterns.abstract_factory;

/**
 * @author Sergei Aleshchenko
 */
public interface GUIFactory {
    Button createButton();
    CheckBox createCheckbox();
}
