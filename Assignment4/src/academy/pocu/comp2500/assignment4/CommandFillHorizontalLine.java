package academy.pocu.comp2500.assignment4;

public class CommandFillHorizontalLine implements ICommand {
    private char[] previousCharacters;
    private char character;
    private int y;
    private boolean isExecuted;
    private boolean isUndo;
    private Canvas canvas;

    public CommandFillHorizontalLine(int y, char character) {
        this.y = y;
        this.isUndo = false;
        this.character = character;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (this.isExecuted == true) {
            return false;
        }

        this.canvas = canvas;

        if (y < 0 || y > this.canvas.getHeight() - 1) {
            return false;
        }

        if (this.character > 31 && this.character < 127) {
            this.previousCharacters = new char[this.canvas.getWidth()];
            for (int j = 0; j < this.canvas.getWidth(); ++j) {
                previousCharacters[j] = this.canvas.getPixel(j, y);
            }

            canvas.fillHorizontalLine(this.y, this.character);
            isExecuted = true;
            return true;
        }
        isExecuted = false;
        return false;
    }

    @Override
    public boolean undo() {
        if (this.isExecuted == true && this.isUndo == false) {
            int widthSize = this.canvas.getWidth();

            char[] currentCharacters = new char[widthSize];

            for (int j = 0; j < this.canvas.getWidth(); ++j) {
                currentCharacters[j] = this.canvas.getPixel(j, y);
            }

            for (int i = 0; i < widthSize; ++i) {
                if (currentCharacters[i] != this.character) {
                    return false;
                }
            }

            for (int i = 0; i < widthSize; ++i) {
                this.canvas.drawPixel(i, this.y, previousCharacters[i]);
            }

            this.isUndo = true;
            return true;
        }

        return false;
    }

    @Override
    public boolean redo() {
        if (this.isExecuted == true && this.isUndo == true) {
            int widthSize = this.canvas.getWidth();

            char[] currentCharacters = new char[widthSize];

            for (int j = 0; j < this.canvas.getWidth(); ++j) {
                currentCharacters[j] = this.canvas.getPixel(j, y);
            }

            for (int i = 0; i < widthSize; ++i) {
                if (currentCharacters[i] != previousCharacters[i]) {
                    return false;
                }
            }

            for (int i = 0; i < widthSize; ++i) {
                this.canvas.drawPixel(i, this.y, this.character);
            }

            this.isUndo = false;
            return true;
        }

        return false;
    }
}
