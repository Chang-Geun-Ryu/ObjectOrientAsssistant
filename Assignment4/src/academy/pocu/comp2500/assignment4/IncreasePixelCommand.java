package academy.pocu.comp2500.assignment4;

public class IncreasePixelCommand extends OnePixelCommand {
    public IncreasePixelCommand(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!checkIfIsExecutable()) {
            return false;
        }
        isUndoable = true;
        this.canvas = canvas;
        if (x < 0 || y < 0) {
            return false;
        }
        if (canvas.increasePixel(x, y)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean undo() {
        if (checkIfIsUndoable()) {
            if (canvas.decreasePixel(x, y)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean redo() {
        if (checkIfIsRedoable()) {
            if (canvas.increasePixel(x, y)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
