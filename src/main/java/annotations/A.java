package annotations;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
@Author(name = "Stephen King", dateOfBirth = 1947)
public class A {
    private int i;
    @Deprecated
    public void test() {
        System.out.println("Hello from class A");
    }
}
