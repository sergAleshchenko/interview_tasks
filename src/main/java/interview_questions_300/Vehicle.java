package interview_questions_300;

/**
 * @author Sergei Aleshchenko
 */
public class Vehicle {
    void run() {
        System.out.println("Vehicle is running");
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run();

        System.out.println("-------------------------");

        Bike bike = new Bike();
        bike.run();

        System.out.println("--------------------------");

        Vehicle vehicle1 = new Bike();
        vehicle1.run();

        System.out.println("--------------------------");

    }
}

class Bike extends Vehicle {
    @Override
    void run() {
        System.out.println("Bike is running safely");
    }
}
