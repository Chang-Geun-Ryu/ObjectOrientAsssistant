package academy.pocu.comp2500.assignment4;

public class CommandFillVerticalLine implements ICommand {
    private char[] previousCharacters;
    private char character;
    private int x;
    private boolean isExecuted;
    private boolean isUndo;
    private Canvas canvas;

    public CommandFillVerticalLine(int x, char character) {
        this.x = x;
        this.isUndo = false;
        this.character = character;
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

        if (this.character > 31 && this.character < 127) {
            this.previousCharacters = new char[this.canvas.getHeight()];

            for (int i = 0; i < this.canvas.getHeight(); ++i) {
                previousCharacters[i] = this.canvas.getPixel(x, i);
            }

            canvas.fillVerticalLine(this.x, this.character);
            isExecuted = true;
            return true;
        }
        isExecuted = false;
        return false;
    }

    @Override
    public boolean undo() {
        if (this.isExecuted == true && this.isUndo == false) {
            int heightSize = this.canvas.getHeight();

            char[] currentCharacters = new char[heightSize];

            for (int i = 0; i < heightSize; ++i) {
                currentCharacters[i] = this.canvas.getPixel(x, i);
            }

            for (int i = 0; i < heightSize; ++i) {
                if (currentCharacters[i] != this.character) {
                    this.isUndo = false;
                    return false;
                }
            }

            for (int i = 0; i < heightSize; ++i) {
                this.canvas.drawPixel(this.x, i, previousCharacters[i]);
            }

            this.isUndo = true;
            return true;
        }

        return false;
    }

    @Override
    public boolean redo() {
        if (this.isExecuted == true && this.isUndo == true) {
            int heightSize = this.canvas.getHeight();

            char[] currentCharacters = new char[heightSize];

            for (int i = 0; i < heightSize; ++i) {
                currentCharacters[i] = this.canvas.getPixel(x, i);
            }

            for (int i = 0; i < heightSize; ++i) {
                if (currentCharacters[i] != previousCharacters[i]) {
                    return false;
                }
            }

            for (int i = 0; i < heightSize; ++i) {
                this.canvas.drawPixel(this.x, i, this.character);
            }

            this.isUndo = false;
            return true;
        }

        return false;
    }
}
