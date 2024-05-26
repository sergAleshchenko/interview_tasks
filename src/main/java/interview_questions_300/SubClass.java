package interview_questions_300;

import java.net.BindException;

/**
 * @author Sergei Aleshchenko
 */
public class SubClass extends SuperClass implements SomeInterface {

    public SubClass() {
        super();
    }

    @Override
    void doSomething(){
    }

    @Override
    public int doSomething(int n) {
        System.out.println("some");
        super.doSomething();
        return 0;
    }
}
