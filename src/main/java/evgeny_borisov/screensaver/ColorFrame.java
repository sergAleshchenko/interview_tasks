package evgeny_borisov.screensaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author Sergei Aleshchenko
 */
@Component
public abstract class ColorFrame extends JFrame {

    public ColorFrame() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1920), random.nextInt(1080));
        getContentPane().setBackground(getColor());
        repaint();
    }

    protected abstract Color getColor();
}
