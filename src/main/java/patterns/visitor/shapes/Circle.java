package patterns.visitor.shapes;

import lombok.Getter;
import patterns.visitor.visitors.Visitor;

/**
 * @author Sergei Aleshchenko
 */
@Getter
public class Circle extends Dot {
    private int radius;

    public Circle(int id, int x, int y, int radius) {
        super(id, x, y);
        this.radius = radius;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCircle(this);
    }
}
