package academy.pocu.comp2500.assignment4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClearCommand implements ICommand {
    private boolean executed;
    private boolean undone;
    private final HashMap<Point, Character> arrHistory;
    private Canvas canvas;
    private int oldCanvasHashCode;
    private int newCanvasHashCode;


    public ClearCommand() {
        this.executed = false;
        this.undone = false;
        this.arrHistory = new HashMap<>();
    }

    @Override
    public boolean execute(Canvas canvas) {
        try {
            if (!executed) {
                this.canvas = canvas;
                backup();
                canvas.clear();
                this.executed = true;
                this.newCanvasHashCode = getCanvasHashCode(canvas);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public boolean undo() {
        try {
            if (executed && !undone && getCanvasHashCode(this.canvas) == newCanvasHashCode) {
                for (Map.Entry<Point, Character> entry : arrHistory.entrySet()) {
                    Point key = entry.getKey();
                    Character value = entry.getValue();
                    this.canvas.drawPixel(key.getX(), key.getY(), value);
                }
                this.undone = true;
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public boolean redo() {
        try {
            if (executed && undone && getCanvasHashCode(this.canvas) == oldCanvasHashCode) {
                this.canvas.clear();
                this.undone = false;
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    private void backup() {
        this.oldCanvasHashCode = getCanvasHashCode(this.canvas);
        this.arrHistory.clear();
        for (int row = 0; row < this.canvas.getHeight(); row++) {
            for (int col = 0; col < this.canvas.getWidth(); col++) {
                if (canvas.getPixel(col, row) != ' ') {
                    arrHistory.put(new Point(col, row), this.canvas.getPixel(col, row));
                }
            }
        }
    }

    private int getCanvasHashCode(Canvas canvas) {
        char[][] tmpCanvas = new char[canvas.getHeight()][canvas.getWidth()];
        for (int row = 0; row < canvas.getHeight(); row++) {
            for (int col = 0; col < canvas.getWidth(); col++) {
                tmpCanvas[row][col] = canvas.getPixel(col, row);
            }
        }
        return Arrays.deepHashCode(tmpCanvas);
    }
}
