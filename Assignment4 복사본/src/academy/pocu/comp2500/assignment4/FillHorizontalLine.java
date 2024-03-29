package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class FillHorizontalLine extends Command {

    private final int Y;
    private final char fillingCharacter;
    private final ArrayList<Character> oldLine;

    public FillHorizontalLine(int y, char character) {
        super();
        this.Y = y;
        this.fillingCharacter = character;
        this.oldLine = new ArrayList<>();
    }

    public int getY() {
        return this.Y;
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
        if (!super.isValidPoint(0, this.getY())) {
            return false;
        }
        super.markExecuting();


        for (int x = 0; x < canvas.getWidth(); x++) {
            this.getOldLine().add(canvas.getPixel(x, this.getY()));
        }

        super.getCanvas().fillHorizontalLine(this.getY(), this.getFillingCharacter());

        super.allowUndo();
        return true;
    }

    @Override
    public boolean undo() {
        if (!super.isUndoable()) {
            return false;
        }
        for (int x = 0; x < super.getCanvas().getWidth(); x++) {
            if (this.getFillingCharacter() != super.getCanvas().getPixel(x, this.getY())) {
                return false;
            }
        }
        super.blockUndo();
        super.allowRedo();
        for (int i = 0; i < super.getCanvas().getWidth(); i++) {
            super.getCanvas().drawPixel(i, this.getY(), this.getOldLine().get(i));
        }
        return true;
    }

    @Override
    public boolean redo() {
        if (!super.isRedoable()) {
            return false;
        }
        for (int x = 0; x < super.getCanvas().getWidth(); x++) {
            if (this.getOldLine().get(x) != super.getCanvas().getPixel(x, this.getY())) {
                return false;
            }
        }
        super.blockRedo();
        super.allowUndo();
        super.getCanvas().fillHorizontalLine(this.getY(), this.getFillingCharacter());
        return true;
    }

}
