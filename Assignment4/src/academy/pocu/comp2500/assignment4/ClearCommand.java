package academy.pocu.comp2500.assignment4;

public class ClearCommand extends Command {
    protected char[][] previousDrawing;

    public ClearCommand() {
        previousDrawing = null;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!checkIfIsExecutable()) {
            return false;
        }
        this.canvas = canvas;
        isUndoable = true;
        previousDrawing = new char[canvas.getHeight()][canvas.getWidth()];
        for (int i = 0; i < canvas.getWidth(); ++i) {
            for (int j = 0; j < canvas.getHeight(); ++j) {
                previousDrawing[j][i] = canvas.getPixel(i, j);
            }
        }
        performClear(canvas);
        return true;
    }

    @Override
    public boolean undo() {
        if (checkIfIsUndoable()) {
            for (int i = 0; i < canvas.getWidth(); ++i) {
                for (int j = 0; j < canvas.getHeight(); ++j) {
                    canvas.drawPixel(i, j, previousDrawing[i][j]);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean redo() {
        if (checkIfIsRedoable()) {
            performClear(canvas);
            return true;
        } else {
            return false;
        }
    }

    private void performClear(Canvas canvas) {
        for (int i = 0; i < canvas.getWidth(); ++i) {
            for (int j = 0; j < canvas.getHeight(); ++j) {
                canvas.drawPixel(i, j, ' ');
            }
        }
    }
}
