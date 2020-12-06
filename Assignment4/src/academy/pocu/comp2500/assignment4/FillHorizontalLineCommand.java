package academy.pocu.comp2500.assignment4;

public class FillHorizontalLineCommand extends FillLineCommand {
    public FillHorizontalLineCommand(int y, char character) {
        super(y, character);
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!checkIfIsExecutable()) {
            return false;
        }
        this.canvas = canvas;
        isUndoable = true;
        if (canvas.getHeight() <= super.vector || super.vector < 0) {
            return false;
        }
        for (int i = 0; i < canvas.getWidth(); ++i) {
            char previousCharacter = canvas.getPixel(i, super.vector);
            super.characters.add(previousCharacter);
        }
        performAction(canvas);
        for (int i = 0; i < canvas.getWidth(); ++i) {
            canvas.drawPixel(i, super.vector, super.character);
        }
        return true;
    }

    @Override
    public boolean undo() {
        if (checkIfIsUndoable()) {
            if (canvas.getHeight() <= super.vector || super.vector < 0) {
                return false;
            }
            for (int i = 0; i < characters.size(); ++i) {
                canvas.drawPixel(i, super.vector, characters.get(i));
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean redo() {
        if (checkIfIsRedoable()) {
            if (canvas.getHeight() <= super.vector || super.vector < 0) {
                return false;
            }
            performAction(canvas);
            return true;
        } else {
            return false;
        }
    }

    private void performAction(Canvas canvas) {
        for (int i = 0; i < canvas.getWidth(); ++i) {
            canvas.drawPixel(i, super.vector, super.character);
        }
    }
}
