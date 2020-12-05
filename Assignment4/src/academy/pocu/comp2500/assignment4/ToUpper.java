package academy.pocu.comp2500.assignment4;

public class ToUpper extends Command {

    private final int X;
    private final int Y;
    private char character;

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

    public char getCharacter() {
        return this.character;
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
        this.character = super.getCanvas().getPixel(this.getX(), this.getY());
        super.getCanvas().toUpper(this.getX(), this.getY());
        return true;
    }

    @Override
    public boolean undo() {
        if (super.isUndoable()) {
            super.blockUndo();
            super.allowRedo();

            char character = super.getCanvas().getPixel(this.getX(), this.getY());
            super.getCanvas().drawPixel(this.getX(), this.getY(), this.getCharacter());

            this.character = character;

            return true;
        }
        return false;
    }

    @Override
    public boolean redo() {
        if (super.isRedoable()) {
            super.blockRedo();
            super.allowUndo();

            this.character = super.getCanvas().getPixel(this.getX(), this.getY());
            super.getCanvas().toUpper(this.getX(), this.getY());
            return true;
        }
        return false;
    }
}
