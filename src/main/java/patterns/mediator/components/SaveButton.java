package patterns.mediator.components;

import patterns.mediator.mediators.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author Sergei Aleshchenko
 */
public class SaveButton extends JButton implements Component {
    private Mediator mediator;

    public SaveButton() {
        super("Save");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent event) {
        mediator.saveChanges();
    }

    @Override
    public String getName() {
        return "SaveButton";
    }
}
