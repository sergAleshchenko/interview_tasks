package patterns.builder;

import patterns.builder.builders.CarBuilder;
import patterns.builder.builders.CarManualBuilder;
import patterns.builder.cars.Car;
import patterns.builder.cars.Manual;
import patterns.builder.director.Director;

/**
 * @author Sergei Aleshchenko
 */
public class Demo {

    public static void main(String[] args) {
        Director director = new Director();


        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);

        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getType());

        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();

        System.out.println("Car manual built:\n" + carManual.print());
    }
}
