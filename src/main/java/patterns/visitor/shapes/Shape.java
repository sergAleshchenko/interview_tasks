package patterns.visitor.shapes;

import patterns.visitor.visitors.Visitor;

/**
 * @author Sergei Aleshchenko
 */
public interface Shape {
    void move(int x, int y);
    void draw();

    String accept(Visitor visitor);
}
