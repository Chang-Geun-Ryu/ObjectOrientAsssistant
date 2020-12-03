package academy.pocu.comp2500.assignment4;

public class DecreasePixel implements ICommand {
    private int x;
    private int y;
    private char beforeValue;
    private char afterValue;
    private int status;
    private Canvas canvas;


    public DecreasePixel(int x, int y) {
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
        boolean b = canvas.decreasePixel(x, y);
        this.afterValue = canvas.getPixel(x, y);
        this.canvas = canvas;
        this.status = 1;
        return b;
    }

    @Override
    public boolean undo() {
        if (this.status != 1) {
            return false;
        }

        if (canvas.getPixel(x, y) != afterValue) {
            return false;
        }

        canvas.drawPixel(x, y, this.beforeValue);
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

        canvas.drawPixel(x, y, this.afterValue);
        this.status = 1;
        return true;
    }
}