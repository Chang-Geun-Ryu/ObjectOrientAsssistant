package academy.pocu.comp2500.assignment4;

public class CommandToUpper implements ICommand {
    private char previousCharacter;
    private char character;
    private int x;
    private int y;
    private boolean isExecuted;
    private boolean isUndo;
    private Canvas canvas;

    public CommandToUpper(int x, int y) {
        this.x = x;
        this.y = y;
        this.isUndo = false;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (this.isExecuted == true) {
            return false;
        }

        this.canvas = canvas;

        if (x < 0 || x > this.canvas.getWidth() - 1) {
            return false;
        }

        if (y < 0 || y > this.canvas.getHeight() - 1) {
            return false;
        }

        char currentValue = canvas.getPixel(this.x, this.y);
        if (currentValue > 31 && currentValue < 127) {
            this.previousCharacter = currentValue;
            if (currentValue > 96 && currentValue < 123) {
                canvas.toUpper(this.x, this.y);
                this.character = (char) (currentValue - 32);
            } else {
                this.character = currentValue;
            }
            isExecuted = true;
            return true;
        }

        isExecuted = false;
        return false;
    }

    @Override
    public boolean undo() {
        if (this.isExecuted == true && this.isUndo == false && this.character == this.canvas.getPixel(this.x, this.y)) {
            this.canvas.drawPixel(this.x, this.y, this.previousCharacter);
            this.isUndo = true;
            return true;
        }

        return false;
    }

    @Override
    public boolean redo() {
        if (this.isExecuted == true && this.isUndo == true && this.previousCharacter == this.canvas.getPixel(this.x, this.y)) {
            this.canvas.drawPixel(this.x, this.y, this.character);
            this.isUndo = false;
            return true;
        }
        return false;
    }
}
