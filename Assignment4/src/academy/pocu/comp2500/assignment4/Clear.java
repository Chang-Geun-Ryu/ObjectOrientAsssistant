package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class Clear extends Command {
    private final ArrayList<ArrayList<Character>> pixels;

    public Clear() {
        super();
        this.pixels = new ArrayList<>();
    }

    public ArrayList<ArrayList<Character>> getPixels() {
        return this.pixels;
    }

    public char getPixel(int x, int y) {
        return this.pixels.get(y).get(x);
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (super.isExecuted()) {
            return false;
        }
        super.markExecuting();
        super.setCanvas(canvas);
        super.allowUndo();

        for (int i = 0; i < canvas.getWidth(); i++) {
            for (int j = 0; j < canvas.getHeight(); j++) {
                this.getPixels().get(j).add(canvas.getPixel(i, j));
                canvas.drawPixel(i, j, ' ');
            }
        }
        return true;
    }

    @Override
    public boolean undo() {
        if (super.isUndoable()) {
            super.allowRedo();
            super.blockUndo();
            for (int i = 0; i < super.getCanvas().getWidth(); i++) {
                for (int j = 0; j < super.getCanvas().getHeight(); j++) {
                    super.getCanvas().drawPixel(i, j, this.getPixel(i, j));
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean redo() {
        if (super.isRedoable()) {
            super.allowUndo();
            super.blockRedo();
            Canvas canvas = super.getCanvas();
            for (int i = 0; i < canvas.getWidth(); i++) {
                for (int j = 0; j < canvas.getHeight(); j++) {
                    this.getPixels().get(j).add(canvas.getPixel(i, j));
                    canvas.drawPixel(i, j, ' ');
                }
            }
            return true;
        }
        return false;
    }
}
