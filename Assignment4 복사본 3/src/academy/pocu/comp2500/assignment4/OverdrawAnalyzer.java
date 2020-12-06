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
                count += this.getOverdrawCount(i, j);
            }
        }
        return 0;
    }

    public int getOverdrawCount(int x, int y) {

        return this.overdrawCount.get(y).get(x);
    }





}