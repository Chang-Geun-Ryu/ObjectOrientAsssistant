package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class FillHorizontalLine extends Command {

    private final int Y;
    private final char character;
    private final ArrayList<Character> originalLine;

    public FillHorizontalLine(int y, char character) {
        super();
        this.Y = y;
        this.character = character;
        this.originalLine = new ArrayList<>();
    }

    public int getY() {
        return this.Y;
    }

    public char getCharacter() {
        return this.character;
    }

    public ArrayList<Character> getOriginalLine() {
        return this.originalLine;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (isExecuted()) {
            return false;
        }
        super.setCanvas(canvas);
        if (!super.isValidPoint(0, this.getY())) {
            return false;
        }
        super.markExecuting();


        for (int x = 0; x < canvas.getWidth(); x++) {
            this.getOriginalLine().add(canvas.getPixel(x, this.getY()));
        }

        super.getCanvas().fillHorizontalLine(this.getY(), this.getCharacter());

        super.allowUndo();
        return true;
    }

    @Override
    public boolean undo() {
        if (super.isUndoable()) {
            super.blockUndo();
            super.allowRedo();
            for (int i = 0; i < super.getCanvas().getWidth(); i++) {
                super.getCanvas().drawPixel(i, this.getY(), this.getOriginalLine().get(i));
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean redo() {
        if (super.isRedoable()) {
            super.blockRedo();
            super.allowUndo();
            super.getCanvas().fillHorizontalLine(this.getY(), this.getCharacter());
            return true;
        }
        return false;
    }

}
