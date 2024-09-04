package interview_300_questions.covariant_types;

/**
 * @author Sergei Aleshchenko
 */
public class Child extends Parent {

    @Override
    Child get() {
        return this;
    }

    void message() {
        System.out.println("Welcome to covariant return type");
    }

    public static void main(String[] args) {
        new Child().get().message();
    }
}
