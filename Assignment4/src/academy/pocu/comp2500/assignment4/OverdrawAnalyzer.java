package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.LinkedList;

public class OverdrawAnalyzer extends Canvas {
    private int totalOverdrawing;
    private LinkedList<Character>[][] totalPixelHistory;

    public OverdrawAnalyzer(int width, int height) {
        super(width, height);
        this.totalPixelHistory = new LinkedList[height][width];
        this.totalOverdrawing = 0;
    }

    public LinkedList<Character> getPixelHistory(int x, int y) {
        return totalPixelHistory[y][x];
    }

    public int getOverdrawCount() {
        return totalOverdrawing;
    }

    public int getOverdrawCount(int x, int y) {
        return totalPixelHistory[y][x].size();
    }

    @Override
    public void drawPixel(int x, int y, char character) {
        if (!(this.getPixel(x, y) == character)) {
            super.drawPixel(x, y, character);
            totalPixelHistory[y][x].add(character);
            totalOverdrawing += 1;
        }
    }

    @Override
    public void fillHorizontalLine(int y, char character) {
        if (this.getHeight() < y) {
            return;
        }
        for (int i = 0; i < this.getWidth(); ++i) {
            if (!(this.getPixel(i, y) == character)) {
                this.drawPixel(i, y, character);
                totalPixelHistory[y][i].add(character);
                totalOverdrawing += 1;
            }
        }
    }

    @Override
    public void fillVerticalLine(int x, char character) {
        if (this.getWidth() < x) {
            return;
        }
        for (int i = 0; i < this.getHeight(); ++i) {
            if (!(this.getPixel(x, i) == character)) {
                this.drawPixel(x, i, character);
                totalPixelHistory[i][x].add(character);
                totalOverdrawing += 1;
            }
        }
    }

    @Override
    public void clear() {
        for (int x = 0; x < this.getWidth(); ++x) {
            for (int y = 0; y < this.getHeight(); ++y) {
                if (!(this.getPixel(x, y) == ' ')) {
                    this.drawPixel(x, y, ' ');
                    totalPixelHistory[y][x].add(' ');
                    totalOverdrawing += 1;
                }
            }
        }
    }
}
