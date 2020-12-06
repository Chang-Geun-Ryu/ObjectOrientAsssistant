package academy.pocu.comp2500.assignment4;

public class DrawPixelCommand extends OnePixelCommand {
    private char character;
    private char previousCharacter;

    public DrawPixelCommand(int x, int y, char character) {
        super(x, y);
        this.character = character;
        this.previousCharacter = 31;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!checkIfIsExecutable()) {
            return false;
        }
        isUndoable = true;
        this.canvas = canvas;
        if (x < 0 || y < 0 || canvas.getWidth() - 1 < x || canvas.getHeight() - 1 < y || (int) this.character < 32 || (int) this.character > 126) {
            return false;
        }
        this.previousCharacter = canvas.getPixel(x, y);
        canvas.drawPixel(x, y, character);
        return true;
    }

    @Override
    public boolean undo() {
        if (checkIfIsUndoable()) {
            if (x < 0 || y < 0 || canvas.getWidth() - 1 < x || canvas.getHeight() - 1 < y || (int) this.character < 32 || (int) this.character > 126) {
                return false;
            }
            canvas.drawPixel(x, y, previousCharacter);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean redo() {
        if (checkIfIsRedoable()) {
            if (x < 0 || y < 0 || canvas.getWidth() - 1 < x || canvas.getHeight() - 1 < y || (int) this.character < 32 || (int) this.character > 126) {
                return false;
            }
            canvas.drawPixel(x, y, character);
            return true;
        } else {
            return false;
        }
    }
}
