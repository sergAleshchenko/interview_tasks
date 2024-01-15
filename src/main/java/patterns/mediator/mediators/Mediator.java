package patterns.mediator.mediators;

import patterns.mediator.Note;
import patterns.mediator.components.Component;

import javax.swing.*;

/**
 * @author Sergei Aleshchenko
 */
public interface Mediator {
    void addNewNote(Note note);

    void deleteNote();

    void getInfoFromList(Note note);

    void saveChanges();

    void markNote();

    void clear();

    void sendToFilter(ListModel listModel);

    void setElementsList(ListModel list);

    void registerComponent(Component component);

    void hideElements(boolean flag);

    void createGUI();
}
