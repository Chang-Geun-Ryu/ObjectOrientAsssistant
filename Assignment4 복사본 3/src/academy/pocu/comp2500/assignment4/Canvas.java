package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;


public class Canvas {
    private final int WIDTH;
    private final int HEIGHT;

    private ArrayList<ArrayList<Character>> pixels;

    public Canvas(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        pixels = new ArrayList<>();
        for (int y = 0; y < this.HEIGHT; y++) {
            pixels.add(new ArrayList<>());
            for (int x = 0; x < this.WIDTH; x++) {
                pixels.get(y).add(' ');
            }
        }
    }

    public int getWidth() {
        return this.WIDTH;
    }

    public int getHeight() {
        return this.HEIGHT;
    }


    public void drawPixel(int x, int y, char character) {
        if (character < 32 || character > 126) {
            return;
        }
        if (this.isValidPoint(x, y)) {
            this.pixels.get(y).set(x, character);
        }
    }

    public char getPixel(int x, int y) {
        return this.pixels.get(y).get(x);
    }

    public boolean increasePixel(int x, int y) {
        if (this.getPixel(x, y) == 126) {
            return false;
        }
        this.pixels.get(y).set(x, (char) ((int) this.pixels.get(y).get(x) + 1));
        return true;
    }

    public boolean decreasePixel(int x, int y) {
        if (this.getPixel(x, y) == 32) {
            return false;
        }
        this.pixels.get(y).set(x, (char) ((int) this.pixels.get(y).get(x) - 1));
        return true;
    }

    public void toUpper(int x, int y) {
        if (this.getPixel(x, y) > 96 && this.getPixel(x, y) < 123) {
            this.pixels.get(y).set(x, (char) ((int) this.pixels.get(y).get(x) - 32));
        }
    }


    public void toLower(int x, int y) {
        if (this.getPixel(x, y) > 64 && this.getPixel(x, y) < 91) {
            this.pixels.get(y).set(x, (char) ((int) this.pixels.get(y).get(x) + 32));
        }
    }

    public void fillHorizontalLine(int y, char character) {
        for (int i = 0; i < this.getWidth(); i++) {
            this.drawPixel(i, y, character);
        }
    }

    public void fillVerticalLine(int x, char character) {
        for (int i = 0; i < this.getHeight(); i++) {
            this.drawPixel(x, i, character);
        }
    }

    public void clear() {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                this.drawPixel(i, j, ' ');
            }
        }
    }

    public String getDrawing() {
        StringBuilder sb = new StringBuilder();

        addHorizontalBorder(sb);
        for (int y = 0; y < this.getHeight(); y++) {
            sb.append('|');
            for (int x = 0; x < this.getWidth(); x++) {
                sb.append(Character.toString(this.getPixel(x, y)));
            }
            sb.append('|');
            sb.append(System.lineSeparator());
        }
        addHorizontalBorder(sb);
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    private void addHorizontalBorder(StringBuilder sb) {
        sb.append('+');
        for (int i = 0; i < this.getWidth(); i++) {
            sb.append('-');
        }
        sb.append('+');
        sb.append(System.lineSeparator());
    }

    public boolean isValidPoint(int x, int y) {
        return 0 <= x && 0 <= y && x < this.WIDTH && y < this.HEIGHT;
    }


}