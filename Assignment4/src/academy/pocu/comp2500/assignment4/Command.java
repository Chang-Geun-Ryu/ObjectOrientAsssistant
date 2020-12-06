package academy.pocu.comp2500.assignment4;

public abstract class Command implements ICommand {
    protected Canvas canvas;
    protected boolean isExecutable;
    protected boolean isRedoable;
    protected boolean isUndoable;

    public Command() {
        canvas = null;
        isExecutable = true;
        isRedoable = false;
        isUndoable = false;
    }

    protected boolean checkIfIsUndoable() {
        if (isUndoable) {
            isUndoable = false;
            isRedoable = true;
            return true;
        } else {
            return false;
        }
    }

    protected boolean checkIfIsRedoable() {
        if (isRedoable) {
            isRedoable = false;
            isUndoable = true;
            return true;
        } else {
            return false;
        }
    }

    protected boolean checkIfIsExecutable() {
        if (isExecutable) {
            isExecutable = false;
            return true;
        } else {
            return false;
        }
    }
}
