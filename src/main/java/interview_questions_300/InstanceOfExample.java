package interview_questions_300;

/**
 * @author Sergei Aleshchenko
 */
public abstract class InstanceOfExample {

    public InstanceOfExample() {
        System.out.println("InstanceOfExample constructor");
    }

    abstract void doSomethingElse();

    void doSomething() {
        System.out.println("InstanceOfExample.doSomething()");
    }

    public static void main(String[] args) {
        InstanceOfChild instanceOfChild = new InstanceOfChild();
        System.out.println(instanceOfChild instanceof InstanceOfExample);

        new InstanceOfExample() {
            @Override
            void doSomethingElse() {
                System.out.println("InstanceOfExample.doSomethingElse()");
            }
        }.doSomethingElse();
    }
}

class InstanceOfChild extends InstanceOfExample {
    @Override
    void doSomething() {
        super.doSomething();
    }

    @Override
    void doSomethingElse() {

    }
}
