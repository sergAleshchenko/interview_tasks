package inheritance.example_2;

public class SomeClass implements SomeInterface1, SomeInterface2{

    private int field;

    public SomeClass() {
        this(2);
        System.out.println("sadf");
    }

    public SomeClass(int field) {
        this.field = field;
        System.out.println("fdsa");
    }

    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();
        someClass.doSomething1();
        someClass.doSomething2();
    }

    @Override
    public void doSomething1() {

    }

    @Override
    public void doSomething2() {

    }
}
