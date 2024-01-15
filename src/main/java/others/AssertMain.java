package others;

import static java.lang.System.*;

public abstract class AssertMain {
    public static void main(String[] args) {
        int length = -1;

//        assert (length >= 0) : "Some message";

        try {
            int a = 1;
            System.out.println(a / 0);
        } catch (ArithmeticException e) {

        } finally {
            System.out.println("rest of the code...");
        }

        try {
            assert (method()) : "AssertionFailed";
            out.println("End");
        } catch (Exception e) {
            out.println("RuntimeEx");
        }

    }

    static boolean method() {
        throw new RuntimeException();
    }

     static  void method2() {

     }
}
