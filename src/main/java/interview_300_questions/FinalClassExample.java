package interview_300_questions;

/**
 * @author Sergei Aleshchenko
 */
public class FinalClassExample {
    public static void main(String[] args) {
        EmployeeFinal employee = new EmployeeFinal("ABC123");
        employee = new EmployeeFinal("11111");

        String pancardNumber = employee.getPancardNumber();
        System.out.println(pancardNumber);
    }
}

final class EmployeeFinal {

    final String pancardNumber;

    public EmployeeFinal(String pancardNumber) {
        this.pancardNumber = pancardNumber;
    }

    public String getPancardNumber() {
        return pancardNumber;
    }
}
