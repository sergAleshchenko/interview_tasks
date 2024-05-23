package interview_questions_300;

/**
 * @author Sergei Aleshchenko
 */
public class Test {
    public static void main(String[] args) {
        Employee employee = new Employee("Sergei", "Tbilisi", 34, 3500);
        System.out.println("Name: " + employee.getName() +
                ", salary: " + employee.getSalary() +
                ", age: " + employee.getAge() +
                ", address: " + employee.getAddress());

        System.out.println("----------------------------------------------------------");


        Employee1 employee1 = new Employee1();
        employee1.printThis();

    }
}
