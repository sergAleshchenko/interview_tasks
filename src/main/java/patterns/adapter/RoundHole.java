package patterns.adapter;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Sergei Aleshchenko
 */
@AllArgsConstructor
@Getter
public class RoundHole {
    private double radius;

//    public boolean fits(RoundPeg peg) {
//        boolean result;
//        result = (this.getRadius() >= peg.getRadius());
//
//        return result;
//    }
}
