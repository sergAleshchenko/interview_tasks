package patterns.adapter;

import lombok.AllArgsConstructor;

/**
 * @author Sergei Aleshchenko
 */
@AllArgsConstructor
public class SquarePegAdapter extends RoundPeg {
    private SquarePeg peg;

    @Override
    public double getRadius() {
        double result;
        result = (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
        return result;
    }
}
