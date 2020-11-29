package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class FillHorizontalLine implements ICommand {
    private int y;
    private char c;
    private ArrayList<Character> brforeValues = new ArrayList<>();
    private int status;
    private Canvas canvas;

    public FillHorizontalLine(int y, char character) {
        this.y = y;
        this.c = character;
        this.status = 0;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (this.status != 0) {
            return false;
        }

        for (int x = 0; x < canvas.getWidth(); ++x) {
            this.brforeValues.add(canvas.getPixel(x, y));
        }

        canvas.fillHorizontalLine(y, c);
        this.canvas = canvas;
        this.status = 1;
        return true;
    }

    @Override
    public boolean undo() {
        if (this.status != 1) {
            return false;
        }

        for (int x = 0; x < canvas.getWidth(); ++x) {
            if (canvas.getPixel(x, y) != c) {
                return false;
            }
        }

        for (int x = 0; x < canvas.getWidth(); ++x) {
            canvas.drawPixel(x, y, this.brforeValues.get(x));
        }

        this.status = 2;
        return true;
    }

    @Override
    public boolean redo() {
        if (this.status != 2) {
            return false;
        }

        for (int x = 0; x < canvas.getWidth(); ++x) {
            if (canvas.getPixel(x, y) != brforeValues.get(x)) {
                return false;
            }
        }

        canvas.fillHorizontalLine(y, c);
        this.status = 1;
        return true;
    }
}