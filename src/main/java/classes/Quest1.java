package classes;

public class Quest1 {
    public void method(Number obj) {
        System.out.print ("1");
    }
    public void method(Character obj) {
        System.out.print ("2");
    }

    public void method(int i) {
        System.out.print ("4");
    }
    public void method(double d) {
        System.out.print("5");
    }

    public static void main(String[] args) {
        Quest1 quest1 = new Quest1();
        Number n = 67;
        Integer i = 78;
        quest1.method(n);
        quest1.method(i);
        quest1.method(3);
    }
}
