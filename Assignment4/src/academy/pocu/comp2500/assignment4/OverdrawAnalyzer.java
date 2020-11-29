package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class OverdrawAnalyzer extends Canvas {
    private HashMap<Integer, LinkedList<Character>> history = new HashMap<>();
    private HashMap<Integer, Integer> overdrawCount = new HashMap<>();
    private HashMap<Integer, Integer> overdrawCountTest = new HashMap<>();

    public OverdrawAnalyzer(int width, int height) {
        super(width, height);

        for (int w = 0; w < width; ++w) {
            for (int h = 0; h < height; ++h) {
                LinkedList<Character> linked = new LinkedList<>();
                linked.add(getPixel(w, h));
                this.history.put(Objects.hash(w, h), linked);
                this.overdrawCount.put(Objects.hash(w, h), 0);
                overdrawCountTest.put(Objects.hash(w, h), 0);
            }
        }
    }

    public LinkedList<Character> getPixelHistory(int x, int y) {
        LinkedList<Character> history = new LinkedList<>();
        for (int i = 1; i < this.history.get(Objects.hash(x, y)).size(); ++i) {

            history.add(this.history.get(Objects.hash(x, y)).get(i));
        }
        return history;
    }

    public int getOverdrawCount(int x, int y) {
        return getPixelHistory(x, y).size();
//        return overdrawCountTest.get(Objects.hash(x, y));
    }

    private int getSingle(int x, int y) {

        return getPixelHistory(x, y).size();
    }

    public int getOverdrawCount() {
        int total = 0;
        for (int y = 0; y < getHeight(); ++y) {
            for (int x = 0; x < getWidth(); ++x) {
                total += getSingle(x, y);
            }
        }
        return total;
    }

    private LinkedList<Character> getPixelList(int x, int y) {
        return this.history.get(Objects.hash(x, y));
    }

    private void addOne(int x, int y) {
        int num = overdrawCountTest.get(Objects.hash(x, y));
        overdrawCountTest.replace(Objects.hash(x, y), num + 1);
    }

    // Override
    @Override
    public void drawPixel(int x, int y, char character) {
        super.drawPixel(x, y, character);

        if (getPixelList(x, y).getLast() != getPixel(x, y)) {
            getPixelList(x, y).add(getPixel(x, y));
            this.overdrawCount.replace(Objects.hash(x, y), this.overdrawCount.get(Objects.hash(x, y)) + 1);
        }
        addOne(x, y);
    }

    @Override
    public boolean increasePixel(int x, int y) {
        if (super.increasePixel(x, y)) {
            if (getPixelList(x, y).getLast() != getPixel(x, y)) {
                getPixelList(x, y).add(getPixel(x, y));
                this.overdrawCount.replace(Objects.hash(x, y), this.overdrawCount.get(Objects.hash(x, y)) + 1);
            }

            addOne(x, y);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean decreasePixel(int x, int y) {
        if (super.decreasePixel(x, y)) {
            if (getPixelList(x, y).getLast() != getPixel(x, y)) {
                getPixelList(x, y).add(getPixel(x, y));
                this.overdrawCount.replace(Objects.hash(x, y), this.overdrawCount.get(Objects.hash(x, y)) + 1);
            }

            addOne(x, y);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void toUpper(int x, int y) {
        super.toUpper(x, y);

        if (getPixelList(x, y).getLast() != getPixel(x, y)) {
            getPixelList(x, y).add(getPixel(x, y));
            this.overdrawCount.replace(Objects.hash(x, y), this.overdrawCount.get(Objects.hash(x, y)) + 1);
        }

        addOne(x, y);
    }

    @Override
    public void toLower(int x, int y) {
        super.toLower(x, y);

        if (getPixelList(x, y).getLast() != getPixel(x, y)) {
            getPixelList(x, y).add(getPixel(x, y));
            this.overdrawCount.replace(Objects.hash(x, y), this.overdrawCount.get(Objects.hash(x, y)) + 1);
        }

        addOne(x, y);
    }

    @Override
    public void fillHorizontalLine(int y, char character) {
        super.fillHorizontalLine(y, character);

        for (int x = 0; x < getWidth(); ++x) {
            if (getPixelList(x, y).getLast() != getPixel(x, y)) {
                getPixelList(x, y).add(getPixel(x, y));
                this.overdrawCount.replace(Objects.hash(x, y), this.overdrawCount.get(Objects.hash(x, y)) + 1);
            }

            addOne(x, y);
        }
    }

    @Override
    public void fillVerticalLine(int x, char character) {
        super.fillVerticalLine(x, character);

        for (int y = 0; y < getHeight(); ++y) {
            if (getPixelList(x, y).getLast() != getPixel(x, y)) {
                getPixelList(x, y).add(getPixel(x, y));
                this.overdrawCount.replace(Objects.hash(x, y), this.overdrawCount.get(Objects.hash(x, y)) + 1);
            }

            addOne(x, y);
        }
    }

    @Override
    public void clear() {
        super.clear();
        for (int y = 0; y < getHeight(); ++y) {
            for (int x = 0; x < getWidth(); ++x) {
                if (getPixelList(x, y).getLast() != getPixel(x, y)) {
                    getPixelList(x, y).add(getPixel(x, y));
                    this.overdrawCount.replace(Objects.hash(x, y), this.overdrawCount.get(Objects.hash(x, y)) + 1);
                }
                addOne(x, y);
            }
        }
    }
}
