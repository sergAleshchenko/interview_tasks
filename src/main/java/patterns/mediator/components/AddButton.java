package patterns.mediator.components;

import patterns.mediator.Note;
import patterns.mediator.mediators.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author Sergei Aleshchenko
 */
public class AddButton extends JButton implements Component {
    private Mediator mediator;

    public AddButton() {
        super("Add");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent event) {
        mediator.addNewNote(new Note());
    }

    @Override
    public String getName() {
        return "AddButton";
    }
}
