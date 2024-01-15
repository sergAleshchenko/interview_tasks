package patterns.command.commands;

import patterns.command.editor.Editor;

/**
 * @author Sergei Aleshchenko
 */
public class CopyCommand extends Command {

    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}
