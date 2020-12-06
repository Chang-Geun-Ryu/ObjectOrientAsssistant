package academy.pocu.comp2500.assignment4;

public class Canvas {
    private final int width;
    private final int height;
    private final char[][] arrCanvas;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        arrCanvas = new char[height][width];
        for (int row = 0; row < this.height; row++) {
            for (int col = 0; col < this.width; col++) {
                arrCanvas[row][col] = ' ';
            }
        }
    }

    public void drawPixel(int positionX, int positionY, char ch) throws Exception {
        if (checkInCanvas(positionX, positionY) && checkChar(ch)) {
            arrCanvas[positionY][positionX] = ch;
        } else {
            throw new Exception();
        }
    }

    public char getPixel(int positionX, int positionY) {
        if (checkInCanvas(positionX, positionY)) {
            return arrCanvas[positionY][positionX];
        }
        return ' '; // 유효하지 않은 범위 조회
    }

    public boolean increasePixel(int positionX, int positionY) throws Exception {
        if (checkInCanvas(positionX, positionY) && checkChar((char) (arrCanvas[positionY][positionX] + 1))) {
//            arrCanvas[positionY][positionX] = (char) (arrCanvas[positionY][positionX] + 1);
            drawPixel(positionX, positionY, (char) (arrCanvas[positionY][positionX] + 1));
            return true;
        }
        return false;
    }

    public boolean decreasePixel(int positionX, int positionY) throws Exception {
        if (checkInCanvas(positionX, positionY) && checkChar((char) (arrCanvas[positionY][positionX] - 1))) {
//            arrCanvas[positionY][positionX] = (char) (arrCanvas[positionY][positionX] - 1);
            drawPixel(positionX, positionY, (char) (arrCanvas[positionY][positionX] - 1));
            return true;
        }
        return false;
    }

    public void toUpper(int positionX, int positionY) throws Exception {
        if (checkInCanvas(positionX, positionY)) {
//            arrCanvas[positionY][positionX] = Character.toUpperCase(arrCanvas[positionY][positionX]);
            drawPixel(positionX, positionY, Character.toUpperCase(arrCanvas[positionY][positionX]));
        } else {
            throw new Exception();
        }
    }

    public void toLower(int positionX, int positionY) throws Exception {
        if (checkInCanvas(positionX, positionY)) {
//            arrCanvas[positionY][positionX] = Character.toLowerCase(arrCanvas[positionY][positionX]);
            drawPixel(positionX, positionY, Character.toLowerCase(arrCanvas[positionY][positionX]));
        } else {
            throw new Exception();
        }
    }

    public void fillHorizontalLine(int positionY, char ch) throws Exception {
        if (checkInCanvas(0, positionY) && checkChar(ch)) {
            for (int i = 0; i < this.width; i++) {
//                arrCanvas[positionY][i] = ch;
                drawPixel(i, positionY, ch);
            }
        } else {
            throw new Exception();
        }
    }

    public void fillVerticalLine(int positionX, char ch) throws Exception {
        if (checkInCanvas(positionX, 0) && checkChar(ch)) {
            for (int i = 0; i < this.height; i++) {
//                arrCanvas[i][positionX] = ch;
                drawPixel(positionX, i, ch);
            }
        } else {
            throw new Exception();
        }
    }

    public void clear() {
        try {
            for (int row = 0; row < this.height; row++) {
                for (int col = 0; col < this.width; col++) {
//                    arrCanvas[row][col] = ' ';
                    drawPixel(col, row, ' ');
                }
            }
        } catch (Exception ignored) {
        }
    }

    public String getDrawing() {
        String strDrawing = "+" + "-".repeat(this.width) + "+" + System.lineSeparator();
        for (int row = 0; row < this.height; row++) {
            strDrawing += "|";
            for (int col = 0; col < this.width; col++) {
                strDrawing += arrCanvas[row][col];
            }
            strDrawing += ("|" + System.lineSeparator());
        }
        strDrawing += ("+" + "-".repeat(this.width) + "+" + System.lineSeparator());
        return strDrawing;
    }

    private boolean checkInCanvas(int positionX, int positionY) {
        return positionX >= 0 && positionX <= this.width && positionY >= 0 && positionY <= this.height;
    }

    private boolean checkChar(char code) {
        return code >= ' ' && code <= '~';
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
