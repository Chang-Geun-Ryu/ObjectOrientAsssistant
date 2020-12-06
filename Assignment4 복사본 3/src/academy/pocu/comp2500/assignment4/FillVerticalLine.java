package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class FillVerticalLine extends Command {

    private final int X;
    private final char character;
    private final ArrayList<Character> originalLine;

    public FillVerticalLine(int x, char character) {
        super();
        this.X = x;
        this.character = character;
        this.originalLine = new ArrayList<>();
    }

    public int getX() {
        return this.X;
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
        if (!super.isValidPoint(this.getX(), 0)) {
            return false;
        }
        super.markExecuting();


        for (int y = 0; y < canvas.getHeight(); y++) {
            this.getOriginalLine().add(canvas.getPixel(this.getX(), y));
        }

        super.getCanvas().fillVerticalLine(this.getX(), this.getCharacter());

        super.allowUndo();
        return true;
    }

    @Override
    public boolean undo() {
        if (super.isUndoable()) {
            super.blockUndo();
            super.allowRedo();
            for (int j = 0; j < super.getCanvas().getHeight(); j++) {
                super.getCanvas().drawPixel(this.getX(), j, this.getOriginalLine().get(j));
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
            super.getCanvas().fillVerticalLine(this.getX(), this.getCharacter());
            return true;
        }
        return false;
    }

}
