package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class Clear extends Command {
    private final ArrayList<ArrayList<Character>> oldPixels;

    public Clear() {
        super();
        this.oldPixels = new ArrayList<>();
    }

    public ArrayList<ArrayList<Character>> getOldPixels() {
        return this.oldPixels;
    }

    public char getOldPixel(int x, int y) {
        return this.oldPixels.get(y).get(x);
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (super.isExecuted()) {
            return false;
        }
        super.markExecuting();
        super.setCanvas(canvas);
        super.allowUndo();

        for (int j = 0; j < canvas.getHeight(); j++) {
            this.getOldPixels().add(new ArrayList<>());
            for (int i = 0; i < canvas.getWidth(); i++) {
                this.getOldPixels().get(j).add(canvas.getPixel(i, j));
                canvas.drawPixel(i, j, ' ');
            }
        }
        return true;
    }

    @Override
    public boolean undo() {
        if (!super.isUndoable()) {
            return false;
        }
        for (int i = 0; i < super.getCanvas().getWidth(); i++) {
            for (int j = 0; j < super.getCanvas().getHeight(); j++) {
                if (super.getCanvas().getPixel(i, j) != ' ') {
                    return false;
                }
            }
        }

        super.allowRedo();
        super.blockUndo();
        for (int i = 0; i < super.getCanvas().getWidth(); i++) {
            for (int j = 0; j < super.getCanvas().getHeight(); j++) {
                super.getCanvas().drawPixel(i, j, this.getOldPixel(i, j));
            }
        }
        return true;
    }

    @Override
    public boolean redo() {
        if (!super.isRedoable()) {
            return false;
        }
        for (int i = 0; i < super.getCanvas().getWidth(); i++) {
            for (int j = 0; j < super.getCanvas().getHeight(); j++) {
                if (super.getCanvas().getPixel(i, j) != this.getOldPixel(i, j)) {
                    return false;
                }
            }
        }

        super.allowUndo();
        super.blockRedo();
        Canvas canvas = super.getCanvas();
        for (int j = 0; j < canvas.getHeight(); j++) {
            for (int i = 0; i < canvas.getWidth(); i++) {
                this.getOldPixels().get(j).add(canvas.getPixel(i, j));
                canvas.drawPixel(i, j, ' ');
            }
        }
        return true;
    }
}
