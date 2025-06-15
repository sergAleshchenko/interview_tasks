package inheritance.example_1;

class A {

    A() {
        System.out.println("A: no arguments");
    }
    A(String args) {
        System.out.println("A: one argument");
    }
}

public class B extends A {

    B() {
        this("");
        System.out.println("B: no arguments");
    }
    B(String args) {
        super("");
        System.out.println("B: one argument");
    }

    public static void main(String[] args) {
        B b = new B();
    }
}
