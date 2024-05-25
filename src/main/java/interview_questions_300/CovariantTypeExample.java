package interview_questions_300;

/**
 * @author Sergei Aleshchenko
 */
public class CovariantTypeExample {

    private final int variable;
    private static final int anotherVariable;

    static {
        anotherVariable = 0;
    }

    public CovariantTypeExample(int variable) {
        this.variable = variable;
    }

    public SuperClass doSomething() {
        return null;
    }
}
