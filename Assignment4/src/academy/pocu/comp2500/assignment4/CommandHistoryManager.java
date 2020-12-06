package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.List;

public class CommandHistoryManager {
    private final List<ICommand> undo = new ArrayList<ICommand>();
    private final List<ICommand> redo = new ArrayList<ICommand>();
    private final Canvas canvas;

    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
    }

    public boolean execute(ICommand command) {
        try {
            redo.clear();
            if (!undo.contains(command)) {
                undo.add(command);
                return command.execute(this.canvas);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean canUndo() {
        return undo.size() > 0;
    }

    public boolean canRedo() {
        return redo.size() > 0;
    }

    public boolean undo() {
        try {
            ICommand command = undo.get(undo.size() - 1);
            command.undo();
            undo.remove(command);
            redo.add(command);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean redo() {
        try {
            ICommand command = redo.get(redo.size() - 1);
            command.redo();
            redo.remove(command);
            undo.add(command);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
