package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class FillVerticalLineCommand extends FillLineCommand {
    public FillVerticalLineCommand(int x, char character) {
        super(x, character);
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!checkIfIsExecutable()) {
            return false;
        }
        this.canvas = canvas;
        isUndoable = true;
        if (canvas.getWidth() <= vector || vector < 0) {
            return false;
        }
        for (int i = 0; i < canvas.getHeight(); ++i) {
            char previousCharacter = canvas.getPixel(super.vector, i);
            characters.add(previousCharacter);
        }
        for (int i = 0; i < canvas.getHeight(); ++i) {
            canvas.drawPixel(super.vector, i, super.character);
        }
        return true;
    }

    @Override
    public boolean undo() {
        if (checkIfIsUndoable()) {
            if (canvas.getWidth() <= vector || vector < 0) {
                return false;
            }
            for (int i = 0; i < characters.size(); ++i) {
                canvas.drawPixel(super.vector, i, characters.get(i));
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean redo() {
        if (checkIfIsRedoable()) {
            if (canvas.getWidth() <= vector || vector < 0) {
                return false;
            }
            for (int i = 0; i < canvas.getHeight(); ++i) {
                canvas.drawPixel(super.vector, i, super.character);
            }
            return true;
        } else {
            return false;
        }
    }
}
