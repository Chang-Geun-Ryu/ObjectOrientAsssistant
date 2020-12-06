package academy.pocu.comp2500.assignment4;

public class DrawPixel extends Command {

    private final int X;
    private final int Y;
    private char newCharacter;
    private char oldCharacter;


    public DrawPixel(int x, int y, char character) {
        super();
        this.X = x;
        this.Y = y;
        this.newCharacter = character;
    }


    protected int getX() {
        return this.X;
    }

    protected int getY() {
        return this.Y;
    }

    protected char getNewCharacter() {
        return this.newCharacter;
    }

    public char getOldCharacter() {
        return this.oldCharacter;
    }

    public boolean execute(Canvas canvas) {
        if (super.isExecuted() || (this.getNewCharacter() < 32 || this.getNewCharacter() > 126)) {
            return false;
        }
        super.setCanvas(canvas);
        if (!super.isValidPoint(this.getX(), this.getY())) {
            return false;
        }
        super.markExecuting();
        this.allowUndo();

        this.oldCharacter = canvas.getPixel(this.getX(), this.getY());
        super.getCanvas().drawPixel(this.X, this.Y, this.newCharacter);
        return true;
    }

    public boolean undo() {
        if (!super.isUndoable()) {
            return false;
        }
        if (super.getCanvas().getPixel(this.getX(), this.getY()) != this.getNewCharacter()) {
            return false;
        }
        super.blockUndo();
        super.allowRedo();

        super.getCanvas().drawPixel(this.getX(), this.getY(), this.getOldCharacter());
        return true;
    }

    public boolean redo() {
        if (!super.isRedoable()) {
            return false;
        }
        if (super.getCanvas().getPixel(this.getX(), this.getY()) != this.getOldCharacter()) {
            return false;
        }
        super.blockRedo();
        super.allowUndo();

        super.getCanvas().drawPixel(this.getX(), this.getY(), this.getNewCharacter());
        return true;
    }


}