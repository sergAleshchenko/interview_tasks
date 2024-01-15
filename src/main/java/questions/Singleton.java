package questions;

public class Singleton {
    private static Singleton instance = null;
    private int i;

    private Singleton() {
        this.i = 90;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton first = Singleton.getInstance();
        System.out.println("First instance integer value: " + first.i);
        first.i = first.i + 90;
        Singleton second = Singleton.getInstance();
        System.out.println("Second instance integer value: " + second.i);

        System.out.println(first == second);
    }
}
