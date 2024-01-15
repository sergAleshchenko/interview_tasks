package patterns.builder.builders;

import patterns.builder.cars.CarType;
import patterns.builder.components.Engine;
import patterns.builder.components.GPSNavigator;
import patterns.builder.components.Transmission;
import patterns.builder.components.TripComputer;

/**
 * @author Sergei Aleshchenko
 */
public interface Builder {
    void setCarType(CarType type);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGPSNavigator(GPSNavigator gpsNavigator);
}
