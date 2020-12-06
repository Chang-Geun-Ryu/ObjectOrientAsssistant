package academy.pocu.comp2500.assignment4;

public class DrawPixel extends Command {

    private final int X;
    private final int Y;
    private char character;


    public DrawPixel(int x, int y, char character) {
        super();
        this.X = x;
        this.Y = y;
        this.character = character;
    }


    protected int getX() {
        return this.X;
    }

    protected int getY() {
        return this.Y;
    }

    protected char getCharacter() {
        return this.character;
    }


    public boolean execute(Canvas canvas) {
        if (super.isExecuted() || (this.getCharacter() < 32 || this.getCharacter() > 126)) {
            return false;
        }
        super.setCanvas(canvas);
        if (!super.isValidPoint(this.getX(), this.getY())) {
            return false;
        }
        super.markExecuting();
        this.allowUndo();
        this.swapPixels();
        return true;
    }

    public boolean undo() {
        if (super.isUndoable()) {
            super.blockUndo();
            super.allowRedo();
            this.swapPixels();
            return true;
        }
        return false;
    }

    public boolean redo() {
        if (super.isRedoable()) {
            super.blockRedo();
            super.allowUndo();
            this.swapPixels();
            return true;
        }
        return false;
    }

    protected void swapPixels() {
        if (super.isExecuted()) {
            char tmpCharacter = super.getCanvas().getPixel(this.X, this.Y);
            super.getCanvas().drawPixel(this.X, this.Y, this.character);
            this.character = tmpCharacter;
        }
    }


}