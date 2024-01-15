package AOP;

/**
 * @author Sergei Aleshchenko
 */
public class Main {
    public static void main(String[] args) {
        printName("John");
        printName("Bob");
        printName("Mary");

    }

    public static void printName(String name) {
        System.out.println(name);
    }
}
