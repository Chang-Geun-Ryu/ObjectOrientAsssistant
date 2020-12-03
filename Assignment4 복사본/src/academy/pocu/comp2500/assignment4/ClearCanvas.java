package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.Scanner;

public class ClearCanvas implements ICommand {
    private ArrayList<Character> undos = new ArrayList<>();
    private Canvas canvas;
    private int status = 0;

    @Override
    public boolean execute(Canvas canvas) {
        if (this.status != 0) {
            return false;
        }

        for (int y = 0; y < canvas.getHeight(); ++y) {
            for (int x = 0; x < canvas.getWidth(); ++x) {
                undos.add(canvas.getPixel(x, y));
            }
        }

        canvas.clear();
        this.canvas = canvas;
        this.status = 1;
        return true;
    }

    @Override
    public boolean undo() {
        if (this.status != 1) {
            return false;
        }

        for (int y = 0; y < canvas.getHeight(); ++y) {
            for (int x = 0; x < canvas.getWidth(); ++x) {
                if (canvas.getPixel(x, y) != 0x20) {
                    return false;
                }
            }

        }

        int i = -1;
        for (int y = 0; y < this.canvas.getHeight(); ++y) {
            for (int x = 0; x < this.canvas.getWidth(); ++x) {
                this.canvas.drawPixel(x, y, this.undos.get(++i));
            }
        }

        this.status = 2;

        return true;
    }

    @Override
    public boolean redo() {
        if (this.status != 2) {
            return false;
        }

        int i = -1;
        for (int y = 0; y < this.canvas.getHeight(); ++y) {
            for (int x = 0; x < this.canvas.getWidth(); ++x) {
                if (canvas.getPixel(x, y) != this.undos.get(++i)) {
                    return false;
                }
            }
        }

        canvas.clear();

        this.status = 1;
        return true;
    }
}
