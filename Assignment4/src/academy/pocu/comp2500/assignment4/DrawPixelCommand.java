package academy.pocu.comp2500.assignment4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DrawPixelCommand implements ICommand {
    private final int x;
    private final int y;
    private final char newCharacter;
    private final HashMap<Point, Character> arrHistory;
    private boolean executed;
    private boolean undone;
    private Canvas canvas;
    private int oldCanvasHashCode;
    private int newCanvasHashCode;

    public DrawPixelCommand(int x, int y, char character) {
        this.x = x;
        this.y = y;
        this.newCharacter = character;
        this.arrHistory = new HashMap<>();
        this.executed = false;
        this.undone = false;
    }

    @Override
    public boolean execute(Canvas canvas) {
        try {
            if (!executed) {
                this.canvas = canvas;
                backup();
                canvas.drawPixel(this.x, this.y, this.newCharacter);
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
                this.canvas.drawPixel(this.x, this.y, this.newCharacter);
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
        arrHistory.put(new Point(this.x, this.y), this.canvas.getPixel(this.x, this.y));
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
