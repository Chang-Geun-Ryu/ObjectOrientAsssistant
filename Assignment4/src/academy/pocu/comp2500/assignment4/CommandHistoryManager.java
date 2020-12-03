package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class CommandHistoryManager {
    private Canvas canvas;
    private ArrayList<ICommand> undoStack;
    private ArrayList<ICommand> redoStack;

    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
        this.undoStack = new ArrayList<>();
        this.redoStack = new ArrayList<>();
    }

    public boolean execute(ICommand command) {
        boolean result = command.execute(this.canvas);
        if (result) {
            this.undoStack.add(command);
        }
        return result;
    }

    public boolean canUndo() {
        return this.undoStack.size() > 0;
    }

    public boolean canRedo() {
        return this.redoStack.size() > 0;
    }

    public boolean undo() {
        if (!this.canUndo()) {
            return false;
        }
        ICommand command = this.undoStack.remove(undoStack.size() - 1);
        command.undo();
        this.redoStack.add(command);
        return true;
    }

    public boolean redo() {
        if (!this.canRedo()) {
            return false;
        }
        ICommand command = this.redoStack.remove(redoStack.size() - 1);
        command.redo();
        this.undoStack.add(command);
        return true;
    }
}
