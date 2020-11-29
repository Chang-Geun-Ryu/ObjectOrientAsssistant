package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Canvas {
    private int width;
    private int height;

    private HashMap<Integer, Pixel> pixels = new HashMap<>();

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;

        for (int w = 0; w < width; ++w) {
            for (int h = 0; h < height; ++h) {
                this.pixels.put(Objects.hash(w, h), new Pixel());
            }
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void drawPixel(int x, int y, char character) {
        this.pixels.get(Objects.hash(x, y)).setValue(character);
    }

    public char getPixel(int x, int y) {
        return this.pixels.get(Objects.hash(x, y)).getValue();
    }

    public boolean increasePixel(int x, int y) {
        return this.pixels.get(Objects.hash(x, y)).increase();
    }

    public boolean decreasePixel(int x, int y) {
        return this.pixels.get(Objects.hash(x, y)).decrease();
    }

    public void toUpper(int x, int y) {
        this.pixels.get(Objects.hash(x, y)).toUpper();
    }

    public void toLower(int x, int y) {
        this.pixels.get(Objects.hash(x, y)).toLower();
    }

    public void fillHorizontalLine(int y, char character) {
        for (int x = 0; x < this.width; ++x) {
            this.pixels.get(Objects.hash(x, y)).setValue(character);
        }
    }

    public void fillVerticalLine(int x, char character) {
        for (int y = 0; y < this.height; ++y) {
            this.pixels.get(Objects.hash(x, y)).setValue(character);
        }
    }

    public void clear() {
        for (int w = 0; w < this.width; ++w) {
            for (int h = 0; h < this.height; ++h) {
                this.pixels.get(Objects.hash(w, h)).clear();
            }
        }
    }

    public String getDrawing() {
        StringBuffer sb = new StringBuffer();
        horizontalDrawing(sb);

        for (int y = 0; y < this.height; ++y) {
            sb.append('|');

            for (int x = 0; x < this.width; ++x) {
                sb.append(this.pixels.get(Objects.hash(x, y)).getValue());
            }

            sb.append('|');
            sb.append(System.lineSeparator());
        }

        horizontalDrawing(sb);

        return sb.toString();
    }

    private void horizontalDrawing(StringBuffer sb) {
        sb.append("+");
        for (int i = 0; i < this.width; ++i) {
            sb.append("-");
        }
        sb.append("+");
        sb.append(System.lineSeparator());
    }
}
