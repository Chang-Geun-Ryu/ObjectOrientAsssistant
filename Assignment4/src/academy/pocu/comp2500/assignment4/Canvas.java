package academy.pocu.comp2500.assignment4;

public class Canvas {
    private int width;
    private int height;
    private char[][] letters;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.letters = new char[height][width];

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                this.letters[i][j] = ' ';
            }
        }
    }

    public void drawPixel(int x, int y, char letter) {
//        test if char is 32 ~ 126
        if (x < 0 || x > width - 1) {
            return;
        }

        if (y < 0 || y > height - 1) {
            return;
        }

        if (letter < 32 || letter > 126) {
            return;
        }

        letters[y][x] = letter;
    }

    public char getPixel(int x, int y) {
        return this.letters[y][x];
    }

    public boolean increasePixel(int x, int y) {
        if (x < 0 || x > width - 1) {
            return false;
        }

        if (y < 0 || y > height - 1) {
            return false;
        }

        int nextValue = (char) (this.letters[y][x] + 1);
        if (nextValue > 31 && nextValue < 127) {
            this.letters[y][x] = (char) nextValue;
            return true;
        }

        return false;
    }

    public boolean decreasePixel(int x, int y) {
        if (x < 0 || x > width - 1) {
            return false;
        }

        if (y < 0 || y > height - 1) {
            return false;
        }

        int nextValue = this.letters[y][x] - 1;
        if (nextValue > 31 && nextValue < 127) {
            this.letters[y][x] = (char) nextValue;
            return true;
        }

        return false;
    }

    public void toUpper(int x, int y) {
        if (x < 0 || x > width - 1) {
            return;
        }

        if (y < 0 || y > height - 1) {
            return;
        }

        int currentValue = this.letters[y][x];

        if (currentValue > 96 && currentValue < 123) {
            this.letters[y][x] = (char) (currentValue - 32);
        }
    }

    public void toLower(int x, int y) {
        if (x < 0 || x > width - 1) {
            return;
        }

        if (y < 0 || y > height - 1) {
            return;
        }

        int currentValue = this.letters[y][x];

        if (currentValue > 64 && currentValue < 91) {
            this.letters[y][x] = (char) (currentValue + 32);
        }
    }

    public void fillHorizontalLine(int y, char character) {
        if (y < 0 || y > height - 1) {
            return;
        }

        if (character < 32 || character > 126) {
            return;
        }

        for (int j = 0; j < this.width; ++j) {
            this.letters[y][j] = character;
        }
    }

    public void fillVerticalLine(int x, char character) {
        if (x < 0 || x > width - 1) {
            return;
        }

        if (character < 32 || character > 126) {
            return;
        }

        for (int i = 0; i < this.height; ++i) {
            this.letters[i][x] = character;
        }
    }

    public void clear() {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                this.letters[i][j] = ' ';
            }
        }
    }

    public String getDrawing() {
        String startAndEndLine = "+";

        for (int i = 0; i < width; ++i) {
            startAndEndLine += '-';
        }

        startAndEndLine += '+';

        String drawing = startAndEndLine + System.lineSeparator();

        for (int i = 0; i < height; ++i) {
            drawing += '|';
            for (int j = 0; j < width; ++j) {
                drawing += this.letters[i][j];
            }
            drawing += '|';
            drawing += System.lineSeparator();
        }
        drawing += startAndEndLine;
        drawing += System.lineSeparator();

        return drawing;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

//    public char[] getWidth(int y) {
//        char[] characters = new char[this.width];
//
//        for (int j = 0; j < this.width; ++j) {
//            characters[j] = this.letters[y][j];
//        }
//
//        return characters;
//    }
//
//    public char[] getHeight(int x) {
//        char[] characters = new char[this.height];
//
//        for (int i = 0; i < this.height; ++i) {
//            characters[i] = this.letters[i][x];
//        }
//
//        return characters;
//    }
}
