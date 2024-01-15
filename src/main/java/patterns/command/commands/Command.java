package patterns.command.commands;

import patterns.command.editor.Editor;

/**
 * @author Sergei Aleshchenko
 */
public abstract class Command {

    public Editor editor;
    private String backup;

    public Command(Editor editor) {
        this.editor = editor;
    }

    void backup() {
        backup = editor.textField.getText();
    }

    public void undo() {
        editor.textField.setText(backup);
    }

    public abstract boolean execute();
}
