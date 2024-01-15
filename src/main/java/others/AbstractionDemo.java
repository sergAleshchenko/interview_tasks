package others;

public class AbstractionDemo {
    public static void main(String[] args) {
        int result = new Calculate() {
            @Override
            int multiply(int a, int b) {
                return a * b;
            }
        }.multiply(3, 6);
        System.out.println(result);
    }
}

abstract class Calculate {
    abstract int multiply(int a, int b);
}
