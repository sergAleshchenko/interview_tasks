package patterns.visitor.visitors;

import patterns.visitor.shapes.Circle;
import patterns.visitor.shapes.CompoundShape;
import patterns.visitor.shapes.Dot;
import patterns.visitor.shapes.Rectangle;

/**
 * @author Sergei Aleshchenko
 */
public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
