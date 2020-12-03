package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class FillVericalLine implements ICommand {
    private int x;
    private char c;
    private ArrayList<Character> beforeValues = new ArrayList<>();
    private int status;
    private Canvas canvas;

    public FillVericalLine(int x, char character) {
        this.x = x;
        this.c = character;
        this.status = 0;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (this.status != 0) {
            return false;
        }

        for (int y = 0; y < canvas.getHeight(); ++y) {
            this.beforeValues.add(canvas.getPixel(x, y));
        }

        canvas.fillVerticalLine(x, c);
        this.canvas = canvas;
        this.status = 1;
        return true;
    }

    @Override
    public boolean undo() {
        if (this.status != 1) {
            return false;
        }

        for (int y = 0; y < canvas.getHeight(); ++y) {
            if (canvas.getPixel(x, y) != c) {
                return false;
            }
        }

        for (int y = 0; y < canvas.getHeight(); ++y) {
            canvas.drawPixel(x, y, this.beforeValues.get(y));
        }

        this.status = 2;
        return true;
    }

    @Override
    public boolean redo() {
        if (this.status != 2) {
            return false;
        }

        for (int y = 0; y < canvas.getHeight(); ++y) {
            if (canvas.getPixel(x, y) != this.beforeValues.get(y)) {
                return false;
            }
        }

        canvas.fillVerticalLine(x, c);
        this.status = 1;
        return true;
    }
}