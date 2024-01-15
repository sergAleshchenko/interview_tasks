package generics;

/**
 * @author Sergei Aleshchenko
 */
public class StringWorker<T, U> {

    private T o1;
    private U o2;

    public StringWorker(T o1, U o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    public T getO1() {
        return o1;
    }

    public static <A, B> String getString(A o1, B o2) {
        return "StringWorker : " +
                o1.toString() + " : " +
                o2.toString();
    }

    public <T1> String getString2(T1 o1, T1 o2) {
        return "StringWorker : " + o1.toString() + " : " + o2.toString();
    }

    public <A> A getString3(A o1, A o2) {
        return o1;
    }

    public <A, B> B anotherMethod(A myValue, B ignore) {
        return ignore;
    }

    public <T1> String getString4(T1 o1, T1 o2) {
        return "StringWorker : " + o1.toString() + " : " + o2.toString();
    }

    @Override
    public String toString() {
        return "StringWorker : " +
                o1.toString() + " : " +
                o2.toString();
    }
}
