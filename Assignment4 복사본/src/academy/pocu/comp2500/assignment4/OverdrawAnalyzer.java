package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.LinkedList;

public class OverdrawAnalyzer extends Canvas {

    private ArrayList<ArrayList<LinkedList<Character>>> pixelHistories;
    private ArrayList<ArrayList<Integer>> overdrawCount;

    public OverdrawAnalyzer(int width, int height) {
        super(width, height);
        pixelHistories = new ArrayList<>();
        overdrawCount = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            pixelHistories.add(new ArrayList<>());
            overdrawCount.add(new ArrayList<>());
            for (int j = 0; j < width; j++) {
                pixelHistories.get(i).add(new LinkedList<>());
            }
        }
    }

    public LinkedList<Character> getPixelHistory(int x, int y) {
        return this.pixelHistories.get(y).get(x);
    }

    public int getOverdrawCount() {
        int count = 0;
        for (int i = 0; i < super.getHeight(); i++) {
            for (int j = 0; j < super.getWidth(); j++) {
                count += this.getPixelHistory(j, i).size();
            }
        }
        return count;
    }

    public int getOverdrawCount(int x, int y) {
        return this.getPixelHistory(x, y).size();
    }


    @Override
    public void drawPixel(int x, int y, char character) {
        char oldCharacter = super.getPixel(x, y);
        super.drawPixel(x, y, character);
        if (oldCharacter == super.getPixel(x, y)) {
            return;
        }
        this.getPixelHistory(x, y).add(super.getPixel(x, y));
    }

    @Override
    public boolean decreasePixel(int x, int y) {
        if (super.decreasePixel(x, y)) {
            this.getPixelHistory(x, y).add(super.getPixel(x, y));
            return true;
        }
        return false;
    }

    @Override
    public boolean increasePixel(int x, int y) {
        if (super.increasePixel(x, y)) {
            this.getPixelHistory(x, y).add(super.getPixel(x, y));
            return true;
        }
        return false;
    }

    @Override
    public void fillHorizontalLine(int y, char character) {
        ArrayList<Character> line = new ArrayList<>();
        for (int i = 0; i < super.getWidth(); i++) {
            line.add(super.getPixel(i, y));
        }
        super.fillHorizontalLine(y, character);
        for (int i = 0; i < super.getWidth(); i++) {
            if (line.get(i) != super.getPixel(i, y)) {
                this.getPixelHistory(i, y).add(super.getPixel(i, y));
            }
        }
    }

    @Override
    public void fillVerticalLine(int x, char character) {
        ArrayList<Character> line = new ArrayList<>();
        for (int i = 0; i < super.getHeight(); i++) {
            line.add(super.getPixel(x, i));
        }
        super.fillVerticalLine(x, character);
        for (int i = 0; i < super.getHeight(); i++) {
            if (line.get(i) != super.getPixel(x, i)) {
                this.getPixelHistory(x, i).add(super.getPixel(x, i));
            }
        }
    }

    @Override
    public void toLower(int x, int y) {
        char oldChar = this.getPixel(x, y);
        super.toLower(x, y);
        if (oldChar != super.getPixel(x, y)) {
            this.getPixelHistory(x, y).add(super.getPixel(x, y));
        }
    }

    @Override
    public void toUpper(int x, int y) {
        char oldChar = this.getPixel(x, y);
        super.toUpper(x, y);
        if (oldChar != super.getPixel(x, y)) {
            this.getPixelHistory(x, y).add(super.getPixel(x, y));
        }
    }

    @Override
    public void clear() {
        ArrayList<ArrayList<Character>> oldCanvas = new ArrayList<>();
        for (int y = 0; y < super.getHeight(); y++) {
            oldCanvas.add(new ArrayList<>());
            for (int x = 0; x < super.getWidth(); x++) {
                oldCanvas.get(y).add(super.getPixel(x, y));
            }
        }
        super.clear();
        for (int y = 0; y < super.getHeight(); y++) {
            for (int x = 0; x < super.getWidth(); x++) {
                if (super.getPixel(x, y) != oldCanvas.get(y).get(x)) {
                    this.getPixelHistory(x, y).add(super.getPixel(x, y));
                }
            }
        }
    }
}