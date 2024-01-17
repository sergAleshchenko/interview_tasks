package patterns.state;

import patterns.state.ui.Player;
import patterns.state.ui.UI;

/**
 * @author Sergei Aleshchenko
 */
public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
