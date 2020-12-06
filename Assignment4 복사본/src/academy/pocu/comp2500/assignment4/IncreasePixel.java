package academy.pocu.comp2500.assignment4;

public class IncreasePixel extends Command {

    private int x;
    private int y;
    private char oldCharacter;

    public IncreasePixel(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
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
        this.oldCharacter = canvas.getPixel(this.getX(), this.getY());

        super.markExecuting();

        if (super.getCanvas().increasePixel(this.getX(), this.getY())) {
            super.allowUndo();
            return true;
        }
        return false;
    }

    @Override
    public boolean undo() {
        if (!super.isUndoable()) {
            return false;
        }
        if (super.getCanvas().getPixel(this.getX(), this.getY()) != this.getOldCharacter() + 1) {
            return false;
        }
        super.blockUndo();
        super.allowRedo();
        super.getCanvas().decreasePixel(this.getX(), this.getY());
        return true;
    }

    @Override
    public boolean redo() {
        if (!super.isRedoable()) {
            return false;
        }
        if (super.getCanvas().getPixel(this.getX(), this.getY()) != this.getOldCharacter()) {
            return false;
        }
        super.blockRedo();
        super.allowUndo();
        super.getCanvas().increasePixel(this.getX(), this.getY());
        return true;
    }


}