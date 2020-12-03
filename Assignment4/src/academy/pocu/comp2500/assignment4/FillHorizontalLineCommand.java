package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class FillHorizontalLineCommand implements ICommand {
    private int y;
    private char character;
    private ArrayList<Character> prevLine;
    private ArrayList<ArrayList<Character>> prevPage;
    private ArrayList<ArrayList<Character>> modifiedPage;
    private boolean executed;
    private Canvas canvas;

    public FillHorizontalLineCommand(int y, char character) {
        this.y = y;
        this.character = character;
        this.prevLine = new ArrayList<>();
        this.prevPage = new ArrayList<>();
        this.modifiedPage = new ArrayList<>();
        this.executed = false;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (this.executed
                || this.y < 0 || this.y > canvas.getHeight()) {
            return false;
        }

        this.canvas = canvas;
        for (int x = 0; x < canvas.getWidth(); ++x) {
            this.prevLine.add(canvas.getPixel(x, this.y));
        }

        this.prevPage = this.copyPage();
        canvas.fillHorizontalLine(this.y, this.character);
        this.modifiedPage = this.copyPage();

        this.executed = true;
        return true;
    }

    @Override
    public boolean undo() {
        if (!this.executed || !this.comparePageWithCanvas(this.modifiedPage)) {
            return false;
        }

        for (int x = 0; x < this.canvas.getWidth(); ++x) {
            this.canvas.drawPixel(x, this.y, this.prevLine.get(x));
        }
        return true;
    }

    @Override
    public boolean redo() {
        if (!this.executed || !this.comparePageWithCanvas(this.prevPage)) {
            return false;
        }

        this.canvas.fillHorizontalLine(this.y, this.character);
        return true;
    }

    private ArrayList<ArrayList<Character>> copyPage() {
        ArrayList<ArrayList<Character>> page = new ArrayList<>();
        for (int y = 0; y < this.canvas.getHeight(); ++y) {
            ArrayList<Character> line = new ArrayList<>();
            for (int x = 0; x < this.canvas.getWidth(); ++x) {
                line.add(this.canvas.getPixel(x, y));
            }
            page.add(line);
        }
        return page;
    }

    private boolean comparePageWithCanvas(ArrayList<ArrayList<Character>> page) {
        for (int y = 0; y < this.canvas.getHeight(); ++y) {
            for (int x = 0; x < this.canvas.getWidth(); ++x) {
                if (this.canvas.getPixel(x, y) != page.get(y).get(x)) {
                    return false;
                }
            }
        }
        return true;
    }
}
