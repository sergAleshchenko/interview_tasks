package patterns.builder.cars;

import lombok.Getter;
import lombok.Setter;
import patterns.builder.components.Engine;
import patterns.builder.components.GPSNavigator;
import patterns.builder.components.Transmission;
import patterns.builder.components.TripComputer;

/**
 * @author Sergei Aleshchenko
 */
@Getter
@Setter
public class Car {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;
    private double fuel = 0;

    public Car(CarType type,
               int seats,
               Engine engine,
               Transmission transmission,
               TripComputer tripComputer,
               GPSNavigator gpsNavigator) {

        this.type = type;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.tripComputer = tripComputer;

        if (this.tripComputer != null) {
            this.tripComputer.setCar(this);
        }

        this.gpsNavigator = gpsNavigator;
    }
}
