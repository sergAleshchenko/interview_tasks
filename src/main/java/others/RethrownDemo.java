package others;

public class RethrownDemo {

    public static void main(String[] args) {
        try {
            int a = 24/0;
        } catch (Exception e) {
            if (e.getClass().equals(ClassCastException.class)) {
                throw e;
            } else {
                System.out.println("nope");
            }
        }
    }
}
