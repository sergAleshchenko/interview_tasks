package interview_300_questions.covariant_types;

import interview_300_questions.SomeInterface;

/**
 * @author Sergei Aleshchenko
 */
public class SubClass extends SuperClass implements SomeInterface {

    public SubClass() {
        super();
    }

    @Override
    void doSomething(){
        System.out.println("SubClass.doSomething() is called");
    }

    @Override
    public int doSomething(int n) {
        System.out.println("SubClass.doSomething(int n) is called");
        super.doSomething();
        return 0;
    }
}
