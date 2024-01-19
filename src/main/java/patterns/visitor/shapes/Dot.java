package patterns.visitor.shapes;

import lombok.Getter;
import patterns.visitor.visitors.Visitor;

/**
 * @author Sergei Aleshchenko
 */
@Getter
public class Dot implements Shape {
    private int id;
    private int x;
    private int y;

    public Dot() {}

    public Dot(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(int x, int y) {

    }

    @Override
    public void draw() {

    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitDot(this);
    }
}
