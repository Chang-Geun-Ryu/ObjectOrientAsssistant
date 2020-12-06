package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class FillVerticalLine extends Command {

    private final int X;
    private final char fillingCharacter;
    private final ArrayList<Character> oldLine;

    public FillVerticalLine(int x, char character) {
        super();
        this.X = x;
        this.fillingCharacter = character;
        this.oldLine = new ArrayList<>();
    }

    public int getX() {
        return this.X;
    }

    public char getFillingCharacter() {
        return this.fillingCharacter;
    }

    public ArrayList<Character> getOldLine() {
        return this.oldLine;
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
            this.getOldLine().add(canvas.getPixel(this.getX(), y));
        }

        super.getCanvas().fillVerticalLine(this.getX(), this.getFillingCharacter());

        super.allowUndo();
        return true;
    }

    @Override
    public boolean undo() {
        if (!super.isUndoable()) {
            return false;
        }
        for (int y = 0; y < super.getCanvas().getHeight(); y++) {
            if (this.getFillingCharacter() != super.getCanvas().getPixel(this.getX(), y)) {
                return false;
            }
        }
        super.blockUndo();
        super.allowRedo();
        for (int j = 0; j < super.getCanvas().getHeight(); j++) {
            super.getCanvas().drawPixel(this.getX(), j, this.getOldLine().get(j));
        }
        return true;
    }

    @Override
    public boolean redo() {
        if (!super.isRedoable()) {
            return false;
        }
        for (int y = 0; y < super.getCanvas().getHeight(); y++) {
            if (this.getOldLine().get(y) != super.getCanvas().getPixel(this.getX(), y)) {
                return false;
            }
        }
        super.blockRedo();
        super.allowUndo();
        super.getCanvas().fillVerticalLine(this.getX(), this.getFillingCharacter());
        return true;
    }

}
