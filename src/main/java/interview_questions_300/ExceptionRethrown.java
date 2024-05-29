package interview_questions_300;

/**
 * @author Sergei Aleshchenko
 */
public class ExceptionRethrown {

    public static void main(String[] args) {
        Calculation calculation = new Calculation();
        try {
            throw calculation;
        } catch (Calculation e) {
            e.add(20, 30);
            try {
                throw calculation;
            } catch (Calculation ex) {
                ex.add(100, 200);
            }
        }
    }
}

class Calculation extends Exception {
    public Calculation() {
        System.out.println("Calculation class is instantiated");
    }

    public void add(int a, int b) {
        System.out.println("The sum is " + (a + b));
    }
}
