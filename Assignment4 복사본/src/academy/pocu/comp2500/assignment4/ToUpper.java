package academy.pocu.comp2500.assignment4;

public class ToUpper extends Command {

    private final int X;
    private final int Y;
    private char oldCharacter;
    private char newCharacter;

    public ToUpper(int x, int y) {
        super();
        this.X = x;
        this.Y = y;
    }


    public int getX() {
        return this.X;
    }

    public int getY() {
        return this.Y;
    }

    public char getOldCharacter() {
        return this.oldCharacter;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (super.isExecuted()) {
            return false;
        }
        super.setCanvas(canvas);
        if (!super.isValidPoint(this.getX(), this.getY())) {
            return false;
        }
        super.markExecuting();


        super.allowUndo();
        this.oldCharacter = super.getCanvas().getPixel(this.getX(), this.getY());
        super.getCanvas().toUpper(this.getX(), this.getY());
        this.newCharacter = super.getCanvas().getPixel(this.getX(), this.getY());
        return true;
    }

    @Override
    public boolean undo() {
        if (!super.isUndoable()) {
            return false;
        }
        if (super.getCanvas().getPixel(this.getX(), this.getY()) != this.newCharacter) {
            return false;
        }
        super.blockUndo();
        super.allowRedo();
        super.getCanvas().drawPixel(this.getX(), this.getY(), this.getOldCharacter());

        return true;
    }

    @Override
    public boolean redo() {
        if (!super.isRedoable()) {
            return false;
        }
        if (super.getCanvas().getPixel(this.getX(), this.getY()) != this.oldCharacter) {
            return false;
        }
        super.blockRedo();
        super.allowUndo();

        this.oldCharacter = super.getCanvas().getPixel(this.getX(), this.getY());
        super.getCanvas().toUpper(this.getX(), this.getY());
        return true;
    }
}
