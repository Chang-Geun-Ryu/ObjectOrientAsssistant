package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class ToUpperCommand implements ICommand {
    private int x;
    private int y;
    private ArrayList<ArrayList<Character>> prevPage;
    private ArrayList<ArrayList<Character>> modifiedPage;
    private boolean executed;
    private Canvas canvas;

    public ToUpperCommand(int x, int y) {
        this.x = x;
        this.y = y;
        this.prevPage = new ArrayList<>();
        this.modifiedPage = new ArrayList<>();
        this.executed = false;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (this.executed
                || this.x < 0 || this.x > canvas.getWidth()
                || this.y < 0 || this.y > canvas.getHeight()) {
            return false;
        }

        this.canvas = canvas;

        this.prevPage = this.copyPage();
        canvas.toUpper(this.x, this.y);
        this.modifiedPage = this.copyPage();

        this.executed = true;
        return true;
    }

    @Override
    public boolean undo() {
        if (!this.executed || !this.comparePageWithCanvas(this.modifiedPage)) {
            return false;
        }

        this.canvas.toLower(this.x, this.y);
        return true;
    }

    @Override
    public boolean redo() {
        if (!this.executed || !this.comparePageWithCanvas(this.prevPage)) {
            return false;
        }

        this.canvas.toUpper(this.x, this.y);
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