package academy.pocu.comp2500.assignment4;

import java.util.HashMap;
import java.util.LinkedList;

public class OverdrawAnalyzer extends Canvas {
    private final HashMap<Point, LinkedList<Character>> arrHistory;

    public OverdrawAnalyzer(int width, int height) {
        super(width, height);
        this.arrHistory = new HashMap<>();
    }

    @Override
    public void drawPixel(int positionX, int positionY, char ch) throws Exception {
        if (this.getPixel(positionX, positionY) != ch) {
            if (arrHistory.get(getKey(positionX, positionY)) == null) {
                arrHistory.put(getKey(positionX, positionY), new LinkedList<>());
            }
            arrHistory.get(getKey(positionX, positionY)).add(ch);
        }
        super.drawPixel(positionX, positionY, ch);
    }

    public LinkedList<Character> getPixelHistory(int x, int y) {
        if (arrHistory.get(getKey(x, y)) == null) {
            return arrHistory.get(getKey(x, y));
        }
        return new LinkedList<Character>();
    }

    public int getOverdrawCount(int x, int y) {
        return arrHistory.get(getKey(x, y)).size();
    }

    public int getOverdrawCount() {
        int sum = 0;
        for (int row = 0; row < this.getHeight(); row++) {
            for (int col = 0; col < this.getWidth(); col++) {
                sum += (arrHistory.get(getKey(col, row)) == null ? 0 : arrHistory.get(getKey(col, row)).size());
            }
        }
        return sum;
    }

    private Point getKey(int x, int y) {
        return new Point(x, y);
    }
}
