package patterns.flyweight.trees;

import lombok.AllArgsConstructor;

import java.awt.*;

/**
 * @author Sergei Aleshchenko
 */
@AllArgsConstructor
public class Tree {
    private int x;
    private int y;
    private TreeType type;

    public void draw(Graphics graphics) {
        type.draw(graphics, x, y);
    }
}
