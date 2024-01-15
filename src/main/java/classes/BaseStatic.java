package classes;

class Base1 {
    public static void print() {
        System.out.println("Base1");
    }
}

class SubClass extends Base1 {
    public static void print() {
        System.out.println("SubClass");
    }

}

public class BaseStatic {
    public static void main(String[] args) {
        Base1 subClass = new SubClass();
        subClass.print();
    }
}
