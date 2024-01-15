package patterns.factory_method;

/**
 * @author Sergei Aleshchenko
 */
public class Demo {
    private static Dialog dialog;

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        configure();
        runBusinessLogic();
    }

    static void configure() {
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    static void runBusinessLogic() {
        dialog.renderWindow();
    }
}
