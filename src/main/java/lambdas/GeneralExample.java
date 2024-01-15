package lambdas;

/**
 * @author Sergei Aleshchenko
 */
public class GeneralExample {

    @FunctionalInterface
    interface LambdaInterface {
        void someMethod(String s, Integer i);
    }

    public static void doSomething(LambdaInterface someLambda) {
        someLambda.someMethod("Matt", 1);
    }

    public static void main(String[] args) {

        doSomething((s, i) -> {
            System.out.println("Hello " + s);
            System.out.println("You are number " + i);
        });
    }
}
