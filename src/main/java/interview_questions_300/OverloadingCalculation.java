package interview_questions_300;

/**
 * @author Sergei Aleshchenko
 */
public class OverloadingCalculation {
    void sum(int a, long b) {
        System.out.println("a method invoked");
    }

    void sum(long a, int b) {
        System.out.println("b method invoked");
    }

    public static void main(String[] args) {
        OverloadingCalculation obj = new OverloadingCalculation();
        obj.sum(20L, 20);
    }
}
