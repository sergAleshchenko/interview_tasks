package patterns.mediator.components;

import patterns.mediator.mediators.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author Sergei Aleshchenko
 */
public class DeleteButton extends JButton implements Component {
    private Mediator mediator;

    public DeleteButton() {
        super("Del");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent event) {
        mediator.deleteNote();
    }

    @Override
    public String getName() {
        return "DelButton";
    }
}
