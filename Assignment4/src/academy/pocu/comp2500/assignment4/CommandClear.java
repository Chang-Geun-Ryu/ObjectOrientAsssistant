package academy.pocu.comp2500.assignment4;

public class CommandClear implements ICommand {
    private char[][] previousCanvas;
    private boolean isExecuted;
    private boolean isUndo;
    private Canvas canvas;
    private int width;
    private int height;

    public CommandClear() {
        this.isUndo = false;
        this.isExecuted = false;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (this.isExecuted == true) {
            return false;
        }

        this.canvas = canvas;
        this.width = this.canvas.getWidth();
        this.height = this.canvas.getHeight();

        this.previousCanvas = new char[height][width];

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                this.previousCanvas[i][j] = this.canvas.getPixel(j, i);
            }
        }

        this.canvas.clear();
        this.isExecuted = true;
        this.isUndo = false;

        return true;
    }

    @Override
    public boolean undo() {
        if (this.isExecuted == true && this.isUndo == false) {
            for (int i = 0; i < height; ++i) {
                for (int j = 0; j < width; ++j) {
                    if (this.canvas.getPixel(j, i) != ' ') {
                        return false;
                    }
                }
            }

            for (int i = 0; i < height; ++i) {
                for (int j = 0; j < width; ++j) {
                    this.canvas.drawPixel(j, i, this.previousCanvas[i][j]);
                }
            }

            this.isUndo = true;
            return true;
        }

        return false;
    }

    @Override
    public boolean redo() {
        if (this.isExecuted == true && this.isUndo == true) {
            for (int i = 0; i < height; ++i) {
                for (int j = 0; j < width; ++j) {
                    if (this.previousCanvas[i][j] != this.canvas.getPixel(j, i)) {
                        return false;
                    }
                }
            }

            for (int i = 0; i < height; ++i) {
                for (int j = 0; j < width; ++j) {
                    this.canvas.clear();
                }
            }

            this.isUndo = false;
            return true;
        }

        return false;
    }
}
