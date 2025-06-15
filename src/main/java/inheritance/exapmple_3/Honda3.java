package inheritance.exapmple_3;

public class Honda3 extends Bike{
    int speedLimit = 150;

    @Override
    void run() {
        System.out.println("Honda3.run()");
    }

    public static void main(String[] args) {
        Bike obj = new Honda3();

        System.out.println(obj.speedLimit);
        obj.run();
    }
}
