package patterns.mediator.components;

import patterns.mediator.Note;
import patterns.mediator.mediators.Mediator;

import javax.management.NotificationEmitter;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * @author Sergei Aleshchenko
 */
public class Filter extends JTextField implements Component {
    private Mediator mediator;
    private ListModel listModel;

    public Filter() {}

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }


    @Override
    protected void processComponentKeyEvent(KeyEvent e) {
        String start = getText();
        searchElements(start);
    }

    private void searchElements(String s) {
        if (listModel == null) {
            return;
        }

        if (s.equals("")) {
            mediator.setElementsList(listModel);
            return;
        }

        ArrayList<Note> notes = new ArrayList<>();
        for (int i = 0; i < listModel.getSize(); i++) {
            notes.add((Note) listModel.getElementAt(i));
        }

        DefaultListModel<Note> listModel = new DefaultListModel<>();
        for (Note note : notes) {
            if (note.getName().contains(s)) {
                listModel.addElement(note);
            }
        }

        mediator.setElementsList(listModel);
    }

    public void setList(ListModel listModel) {
        this.listModel = listModel;
    }

    @Override
    public String getName() {
        return "Filter";
    }
}
