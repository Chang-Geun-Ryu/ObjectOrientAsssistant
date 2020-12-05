package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class Canvas {
    private int width;
    private int height;
    private ArrayList<ArrayList<Character>> page;
    private int snapshotNum;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.initPage();
        this.snapshotNum = 0;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void drawPixel(int x, int y, char character) {
        this.page.get(y).set(x, character);
    }

    public char getPixel(int x, int y) {
        return this.page.get(y).get(x);
    }

    public boolean increasePixel(int x, int y) {
        char character = this.getPixel(x, y);
        int ascii = character;
        if (ascii > 125) {
            return false;
        }
        char newCharacter = (char) (ascii + 1);
        this.drawPixel(x, y, newCharacter);
        return true;
    }

    public boolean decreasePixel(int x, int y) {
        char character = this.getPixel(x, y);
        int ascii = character;
        if (ascii < 33) {
            return false;
        }
        char newCharacter = (char) (ascii - 1);
        this.drawPixel(x, y, newCharacter);
        return true;
    }

    public void toUpper(int x, int y) {
        char character = this.getPixel(x, y);
        char newCharacter = Character.toUpperCase(character);
        if (newCharacter != character) {
            this.drawPixel(x, y, newCharacter);
        }
    }

    public void toLower(int x, int y) {
        char character = this.getPixel(x, y);
        char newCharacter = Character.toLowerCase(character);
        if (newCharacter != character) {
            this.drawPixel(x, y, newCharacter);
        }
    }

    public void fillHorizontalLine(int y, char character) {
        ArrayList<Character> newLine = new ArrayList<>();
        for (int i = 0; i < this.width; ++i) {
            newLine.add(character);
        }
        this.page.set(y, newLine);
    }

    public void fillVerticalLine(int x, char character) {
        for (int i = 0; i < this.height; ++i) {
            this.drawPixel(x, i, character);
        }
    }

    public void clear() {
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

    public String getDrawing() {
        ArrayList<String> lines = new ArrayList<>();
        lines.add(String.format("+%s+", "-".repeat(this.width)));
        for (ArrayList<Character> pageLine : this.page) {
            StringBuilder sb = new StringBuilder();
            sb.append("|");
            for (char character : pageLine) {
                sb.append(character);
            }
            sb.append("|");
            lines.add(sb.toString());
        }
        lines.add(String.format("+%s+", "-".repeat(this.width)));

        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            builder.append(line).append(System.lineSeparator());
        }

        return builder.toString();
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
}
