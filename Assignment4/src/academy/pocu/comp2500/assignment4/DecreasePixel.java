package academy.pocu.comp2500.assignment4;

public class DecreasePixel extends Command {

    private int x;
    private int y;

    public DecreasePixel(int x, int y) {
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
        if (super.getCanvas().decreasePixel(this.getX(), this.getY())) {
            super.allowUndo();
            return true;
        }
        return false;
    }

    @Override
    public boolean undo() {
        if (super.isUndoable()) {
            super.blockUndo();
            super.allowRedo();
            super.getCanvas().increasePixel(this.getX(), this.getY());
        }
        return false;
    }

    @Override
    public boolean redo() {
        if (super.isRedoable()) {
            super.blockRedo();
            super.allowUndo();
            super.getCanvas().decreasePixel(this.getX(), this.getY());
        }
        return false;
    }

}
