package patterns.visitor.shapes;

import lombok.Getter;
import patterns.visitor.visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
public class CompoundShape implements Shape {
    @Getter
    public int id;
    public List<Shape> children = new ArrayList<>();


    public CompoundShape(int id) {
        this.id = id;
    }

    @Override
    public void move(int x, int y) {}

    @Override
    public void draw() {}

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCompoundGraphic(this);
    }

    public void add(Shape shape) {
        children.add(shape);
    }
}
