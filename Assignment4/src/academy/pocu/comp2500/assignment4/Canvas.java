package academy.pocu.comp2500.assignment4;

public class Canvas {
    private int width;
    private int height;
    private char[][] drawingPaper;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        drawingPaper = new char[height][width];
        fillEmptyPaper(drawingPaper, width, height);
    }

    public void drawPixel(int x, int y, char character) {
        if (x > width || y > height || (int) character < 32 || (int) character > 126) {
            return;
        }
        drawingPaper[y][x] = character;
    }

    public char getPixel(int x, int y) {
        return drawingPaper[y][x];
    }

    public boolean increasePixel(int x, int y) {
        if (!isInbound(x, y)) {
            return false;
        }
        int numberOfAsciiIncreased = (int) drawingPaper[y][x] + 1;
        if (numberOfAsciiIncreased > 126) {
            return false;
        }

        drawingPaper[y][x] += 1;
        return true;
    }

    public boolean decreasePixel(int x, int y) {
        if (!isInbound(x, y)) {
            return false;
        }
        int numberOfAsciiDecreased = (int) drawingPaper[y][x] - 1;
        if (numberOfAsciiDecreased < 32) {
            return false;
        }
        drawingPaper[y][x] -= 1;
        return true;
    }

    public void toUpper(int x, int y) {
        if (!isInbound(x, y)) {
            return;
        }
        int numberOfAscii = (int) drawingPaper[y][x];
        if (97 <= numberOfAscii && numberOfAscii <= 122) {
            drawingPaper[y][x] -= 32;
        }
    }

    public void toLower(int x, int y) {
        if (!isInbound(x, y)) {
            return;
        }
        int numberOfAscii = (int) drawingPaper[y][x];
        if (65 <= numberOfAscii && numberOfAscii <= 90) {
            drawingPaper[y][x] += 32;
        }
    }

    public void fillHorizontalLine(int y, char shape) {
        if (height < y) {
            return;
        }
        for (int i = 0; i < width; ++i) {
            drawingPaper[y][i] = shape;
        }
    }

    public void fillVerticalLine(int x, char shape) {
        if (width < x) {
            return;
        }
        for (int i = 0; i < height; ++i) {
            drawingPaper[i][x] = shape;
        }
    }

    public void clear() {
        fillEmptyPaper(drawingPaper, width, height);
    }

    public String getDrawing() {
        int widthOfDrawingWithFrame = width + 2;
        int heightOfDrawingWithFrame = height + 2;
        StringBuilder stringBuilder = new StringBuilder(4096);
        for (int i = 0; i < heightOfDrawingWithFrame; ++i) {
            for (int j = 0; j < widthOfDrawingWithFrame; ++j) {
                if (i == 0 || i == heightOfDrawingWithFrame - 1) {
                    if (j == 0 || j == widthOfDrawingWithFrame - 1) {
                        stringBuilder.append('+');
                    } else {
                        stringBuilder.append('-');
                    }
                } else if (j == 0 || j == widthOfDrawingWithFrame - 1) {
                    stringBuilder.append('|');
                } else {
                    stringBuilder.append(drawingPaper[i - 1][j - 1]);
                }
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void fillEmptyPaper(char[][] drawingPaper, int width, int height) {
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                drawingPaper[y][x] = ' ';
            }
        }
    }

    private boolean isInbound(int x, int y) {
        if (x < width && y < height) {
            return true;
        } else {
            return false;
        }
    }
}
