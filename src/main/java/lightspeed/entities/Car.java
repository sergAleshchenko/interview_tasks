package lightspeed.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Sergei Aleshchenko
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Car {
    private String model;
    private int year;
    private CarEngine engine;
}
