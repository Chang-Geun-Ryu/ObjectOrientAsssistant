package academy.pocu.comp2500.assignment4;

import java.util.LinkedList;

public class OverdrawAnalyzer extends Canvas {

    public OverdrawAnalyzer(int width, int height) {
        super(width, height);
    }

//    private LinkedList<Character>[][] historyChacracters;

//        this.historyChacracters = new LinkedList[height][width];
//
//        for (int i = 0; i < height; ++i) {
//            for (int j = 0; j < width; ++j) {
//                this.historyChacracters[i][j] = new LinkedList<Character>();
//            }
//        }

//    public void drawPixel(int x, int y, char letter) {
//        if (x < 0 || x > super.getWidth() - 1) {
//            return;
//        }
//
//        if (y < 0 || y > super.getHeight() - 1) {
//            return;
//        }
//
//        if (letter < 32 || letter > 126) {
//            return;
//        }
//
//        char currentCharacter = super.getPixel(x, y);
//
//        if (currentCharacter != letter) {
//            this.historyChacracters[y][x].add(letter);
//        }
//
//        super.drawPixel(x, y, letter);
//    }
//
//
//    public boolean increasePixel(int x, int y) {
//        if (x < 0 || x > super.getWidth() - 1) {
//            return false;
//        }
//
//        if (y < 0 || y > super.getHeight() - 1) {
//            return false;
//        }
//
//        int nextValue = (super.getPixel(x, y) + 1);
//        if (nextValue > 31 && nextValue < 127) {
//            this.historyChacracters[y][x].add((char) nextValue);
//            super.increasePixel(x, y);
//            return true;
//        }
//
//        return false;
//    }
//
//    public boolean decreasePixel(int x, int y) {
//        if (x < 0 || x > super.getWidth() - 1) {
//            return false;
//        }
//
//        if (y < 0 || y > super.getHeight() - 1) {
//            return false;
//        }
//
//        int nextValue = (super.getPixel(x, y) - 1);
//        if (nextValue > 31 && nextValue < 127) {
//            this.historyChacracters[y][x].add((char) nextValue);
//            super.decreasePixel(x, y);
//            return true;
//        }
//
//        return false;
//    }
//
//    public void toUpper(int x, int y) {
//        if (x < 0 || x > super.getWidth() - 1) {
//            return;
//        }
//
//        if (y < 0 || y > super.getHeight() - 1) {
//            return;
//        }
//
//        int currentValue = super.getPixel(x, y);
//
//        if (currentValue > 96 && currentValue < 123) {
//            super.toUpper(x, y);
//            this.historyChacracters[y][x].add((char) (currentValue - 32));
//        }
//    }
//
//    public void toLower(int x, int y) {
//        if (x < 0 || x > super.getWidth() - 1) {
//            return;
//        }
//
//        if (y < 0 || y > super.getHeight() - 1) {
//            return;
//        }
//
//        int currentValue = super.getPixel(x, y);
//
//        if (currentValue > 64 && currentValue < 91) {
//            super.toLower(x, y);
//            this.historyChacracters[y][x].add((char) (currentValue + 32));
//        }
//    }
//
//    public void fillHorizontalLine(int y, char character) {
//        if (y < 0 || y > super.getHeight() - 1) {
//            return;
//        }
//
//        if (character < 32 || character > 126) {
//            return;
//        }
//
//        for (int j = 0; j < super.getWidth(); ++j) {
//            if (super.getPixel(j, y) != character) {
//                this.historyChacracters[y][j].add(character);
//            }
//        }
//
//        super.fillHorizontalLine(y, character);
//    }
//
//    public void fillVerticalLine(int x, char character) {
//        if (x < 0 || x > super.getWidth() - 1) {
//            return;
//        }
//
//        if (character < 32 || character > 126) {
//            return;
//        }
//
//        for (int i = 0; i < super.getHeight(); ++i) {
//            if (super.getPixel(x, i) != character) {
//                this.historyChacracters[i][x].add(character);
//            }
//        }
//    }
//
//    public void clear() {
//        for (int i = 0; i < super.getHeight(); ++i) {
//            for (int j = 0; j < super.getWidth(); ++j) {
//                if (super.getPixel(j, i) != ' ') {
//                    this.historyChacracters[i][j].add(' ');
//                }
//            }
//        }
//    }

    public LinkedList<Character> getPixelHistory(int x, int y) {
//        LinkedList<Character> charactersHistory = historyChacracters[y][x];
//        System.out.println(charactersHistory.size());
        return null;
    }

    public int getOverdrawCount(int x, int y) {
//        int counter = historyChacracters[y][x].size();

        return 0;
    }

    public int getOverdrawCount() {
//        int counter = 0;
//
//        for (int i = 0; i < super.getHeight(); ++i) {
//            for (int j = 0; j < super.getWidth(); ++j) {
//                counter += historyChacracters[i][j].size();
//            }
//        }

        return 0;
    }
}
