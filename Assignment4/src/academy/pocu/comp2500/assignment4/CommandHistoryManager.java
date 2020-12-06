package academy.pocu.comp2500.assignment4;

import java.util.LinkedList;

public class CommandHistoryManager {
    private Canvas canvas;
    private LinkedList<ICommand> undoableCommandList;
    private LinkedList<ICommand> redoableCommandList;

    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
        this.undoableCommandList = new LinkedList<>();
        this.redoableCommandList = new LinkedList<>();
    }

    public boolean execute(ICommand iCommand) {
        this.undoableCommandList.add(iCommand);
        this.redoableCommandList = new LinkedList<>();
        if (iCommand.execute(canvas)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canUndo() {
        if (undoableCommandList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canRedo() {
        if (redoableCommandList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean undo() {
        if (undoableCommandList.size() == 0) {
            return false;
        }
        ICommand selectedUndo = undoableCommandList.getLast();
        selectedUndo.undo();
        undoableCommandList.removeLast();
        redoableCommandList.add(selectedUndo);
        return true;
    }

    public boolean redo() {
        if (redoableCommandList.size() == 0) {
            return false;
        }
        ICommand selectedRedo = redoableCommandList.getLast();
        selectedRedo.redo();
        redoableCommandList.removeLast();
        undoableCommandList.add(selectedRedo);
        return true;
    }
}
