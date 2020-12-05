package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class FillVerticalLineCommand implements ICommand {
    private int x;
    private char character;
    private ArrayList<Character> prevLine;
    private ArrayList<ArrayList<Character>> prevPage;
    private ArrayList<ArrayList<Character>> modifiedPage;
    private boolean executed;
    private Canvas canvas;

    public FillVerticalLineCommand(int x, char character) {
        this.x = x;
        this.character = character;
        this.prevLine = new ArrayList<>();
        this.prevPage = new ArrayList<>();
        this.modifiedPage = new ArrayList<>();
        this.executed = false;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (this.executed
                || this.x < 0 || this.x > canvas.getWidth()) {
            return false;
        }

        this.canvas = canvas;
        for (int y = 0; y < canvas.getHeight(); ++y) {
            this.prevLine.add(canvas.getPixel(this.x, y));
        }

        this.prevPage = this.copyPage();
        canvas.fillVerticalLine(this.x, this.character);
        this.modifiedPage = this.copyPage();

        this.executed = true;
        return true;
    }

    @Override
    public boolean undo() {
        if (!this.executed || !this.comparePageWithCanvas(this.modifiedPage)) {
            return false;
        }

        for (int y = 0; y < this.canvas.getHeight(); ++y) {
            this.canvas.drawPixel(this.x, y, this.prevLine.get(y));
        }
        return true;
    }

    @Override
    public boolean redo() {
        if (!this.executed || !this.comparePageWithCanvas(this.prevPage)) {
            return false;
        }

        this.canvas.fillVerticalLine(this.x, this.character);
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
