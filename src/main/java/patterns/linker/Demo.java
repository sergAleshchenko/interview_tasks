package patterns.linker;

import patterns.linker.editor.ImageEditor;
import patterns.linker.shapes.Circle;
import patterns.linker.shapes.CompoundShape;
import patterns.linker.shapes.Dot;
import patterns.linker.shapes.Rectangle;

import java.awt.*;


/**
 * @author Sergei Aleshchenko
 */
public class Demo {
    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();

        editor.loadShapes(
                new Circle(10, 10, 10, Color.BLUE),

                new CompoundShape(
                        new Circle(110, 110, 50, Color.RED),
                        new Dot(170, 170, Color.RED)
                ),

                new CompoundShape(
                        new Rectangle(20, 20, 100, 100, Color.GREEN),
                        new Dot(240, 240, Color.GREEN),
                        new Dot(240, 360, Color.GREEN),
                        new Dot(360, 360, Color.GREEN),
                        new Dot(360, 240, Color.GREEN)
                )
        );
    }
}
