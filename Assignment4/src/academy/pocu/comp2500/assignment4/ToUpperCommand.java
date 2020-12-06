package academy.pocu.comp2500.assignment4;

public class ToUpperCommand extends OnePixelCommand {
    public ToUpperCommand(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!checkIfIsExecutable()) {
            return false;
        }
        this.canvas = canvas;
        isUndoable = true;
        if (canvas.getWidth() <= x || canvas.getHeight() <= y || x < 0 || y < 0) {
            return false;
        }
        int numberOfAscii = (int) canvas.getPixel(x, y);
        if (97 <= numberOfAscii && numberOfAscii <= 122) {
            canvas.drawPixel(x, y, (char) (numberOfAscii - 32));

        }
        return true;
    }

    @Override
    public boolean undo() {
        if (checkIfIsUndoable()) {
            if (canvas.getWidth() <= x || canvas.getHeight() <= y || x < 0 || y < 0) {
                return false;
            }
            int numberOfAscii = (int) canvas.getPixel(x, y);
            if (65 <= numberOfAscii && numberOfAscii <= 90) {
                canvas.toLower(x, y);
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
            if (canvas.getWidth() <= x || canvas.getHeight() <= y || x < 0 || y < 0) {
                return false;
            }
            int numberOfAscii = (int) canvas.getPixel(x, y);
            if (97 <= numberOfAscii && numberOfAscii <= 122) {
                canvas.drawPixel(x, y, (char) (numberOfAscii - 32));
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
