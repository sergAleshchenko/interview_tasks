package annotations;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class TestAnnotation {

    @MethodInfo(purpose = "Print Hello World")
    public void printHelloWorld() {
        System.out.println("Hello world!");
    }
}
