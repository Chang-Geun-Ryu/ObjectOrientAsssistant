package academy.pocu.comp2500.assignment4;

public abstract class Command implements ICommand {
    private boolean isExecuted;
    private boolean isUndoable;
    private boolean isRedoable;

    private Canvas canvas;

    public Command() {
        this.isExecuted = false;
        this.isUndoable = false;
        this.isRedoable = false;

        this.canvas = null;
    }

    protected Canvas getCanvas() {
        return this.canvas;
    }

    protected boolean isExecuted() {
        return this.isExecuted;
    }

    protected void markExecuting() {
        this.isExecuted = true;
    }

    protected boolean isUndoable() {
        return this.isUndoable;
    }

    protected void blockUndo() {
        this.isUndoable = false;
    }

    protected void allowUndo() {
        this.isUndoable = true;
    }

    protected boolean isRedoable() {
        return this.isRedoable;
    }

    protected void blockRedo() {
        this.isRedoable = false;
    }

    protected void allowRedo() {
        this.isRedoable = true;
    }

    protected void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    protected boolean isValidPoint(int x, int y) {
        if (this.getCanvas() == null) {
            return false;
        }
        return this.getCanvas().isValidPoint(x, y);
    }

}