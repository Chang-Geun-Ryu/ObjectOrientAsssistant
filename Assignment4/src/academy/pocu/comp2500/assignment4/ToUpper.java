package academy.pocu.comp2500.assignment4;

public class ToUpper implements ICommand {
    private int x;
    private int y;
    private char beforeValue;
    private char afterValue;
    private Canvas canvas;
    private int status;

    public ToUpper(int x, int y) {
        this.x = x;
        this.y = y;
        this.status = 0;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (this.status != 0) {
            return false;
        }

        this.beforeValue = canvas.getPixel(x, y);
        canvas.toUpper(x, y);
        this.afterValue = canvas.getPixel(x, y);
        this.canvas = canvas;
        this.status = 1;
        return true;
    }

    @Override
    public boolean undo() {
        if (this.status != 1) {
            return false;
        }

        if (canvas.getPixel(x, y) != afterValue) {
            return false;
        }

        this.canvas.drawPixel(x, y, beforeValue);
        this.status = 2;
        return true;
    }

    @Override
    public boolean redo() {
        if (this.status != 2) {
            return false;
        }

        if (canvas.getPixel(x, y) != beforeValue) {
            return false;
        }

        this.canvas.drawPixel(x, y, afterValue);
        this.status = 1;
        return true;
    }
}
