package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.LinkedList;

public class OverdrawAnalyzer extends Canvas {
    private int width;
    private int height;
    private ArrayList<ArrayList<Character>> page;
    private int snapshotNum;
    private ArrayList<ArrayList<LinkedList<Character>>> pageHistory;

    public OverdrawAnalyzer(int width, int height) {
        super(width, height);
        this.width = width;
        this.height = height;
        this.initPage();
        this.snapshotNum = 0;
        this.initHistory();
    }

    public LinkedList<Character> getPixelHistory(int x, int y) {
        return this.pageHistory.get(y).get(x);
    }

    public int getOverdrawCount() {
        int count = 0;
        for (int i = 0; i < this.height; ++i) {
            for (int j = 0; j < this.width; ++j) {
                count += this.pageHistory.get(j).get(i).size() - 1;
            }
        }
        return count;
    }

    public int getOverdrawCount(int x, int y) {
        return this.pageHistory.get(y).get(x).size() - 1;
    }

    @Override
    public void drawPixel(int x, int y, char character) {
        super.drawPixel(x, y, character);
        this.addPixelToHistory(x, y, character);
    }

    @Override
    public void fillHorizontalLine(int y, char character) {
        super.fillHorizontalLine(y, character);
        for (int x = 0; x < this.width; ++x) {
            this.addPixelToHistory(x, y, character);
        }
    }

    @Override
    public void fillVerticalLine(int x, char character) {
        super.fillVerticalLine(x, character);
        for (int y = 0; y < this.height; ++y) {
            this.addPixelToHistory(x, y, character);
        }
    }

    @Override
    public void clear() {
        super.clear();
        for (int y = 0; y < this.height; ++y) {
            for (int x = 0; x < this.width; ++x) {
                this.addPixelToHistory(x, y, ' ');
            }
        }
    }

    private void initPage() {
        this.page = new ArrayList<>();
        for (int i = 0; i < this.height; ++i) {
            ArrayList<Character> line = new ArrayList<>();
            char pixel = ' ';
            for (int j = 0; j < this.width; ++j) {
                line.add(pixel);
            }
            this.page.add(line);
        }
    }

    private void initHistory() {
        this.pageHistory = new ArrayList<>();
        for (int i = 0; i < this.height; ++i) {
            ArrayList<LinkedList<Character>> line = new ArrayList<>();
            char pixel = ' ';
            for (int j = 0; j < this.width; ++j) {
                LinkedList<Character> his = new LinkedList<>();
                his.add(pixel);
                line.add(his);
            }
            this.pageHistory.add(line);
        }
    }

    private void addPixelToHistory(int x, int y, char character) {
        Character his = this.pageHistory.get(y).get(x).getLast();
        if (character != his) {
            this.pageHistory.get(y).get(x).add(character);
        }
    }
}
