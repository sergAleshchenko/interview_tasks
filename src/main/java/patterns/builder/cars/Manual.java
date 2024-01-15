package patterns.builder.cars;

import lombok.AllArgsConstructor;
import patterns.builder.components.Engine;
import patterns.builder.components.GPSNavigator;
import patterns.builder.components.Transmission;
import patterns.builder.components.TripComputer;

/**
 * @author Sergei Aleshchenko
 */
@AllArgsConstructor
public class Manual {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;


    public String print() {
        StringBuilder info = new StringBuilder();

        info.append("Type of car: ").append(type).append("\n");
        info.append("Count of seats: ").append(seats).append("\n");

        info.append("Engine: volume - ").append(engine.getVolume())
                .append("; mileage - ").append(engine.getMileage())
                .append("\n");

        info.append("Transmission: ").append(transmission).append("\n");

        if (this.tripComputer != null) {
            info.append("Trip Computer: Functional").append("\n");
        } else {
            info.append("Trip Computer: N/A").append("\n");
        }

        if (this.gpsNavigator != null) {
            info.append("GPS Navigator: Functional").append("\n");
        } else {
            info.append("GPS Navigator: N/A").append("\n");
        }

        return info.toString();
    }
}
