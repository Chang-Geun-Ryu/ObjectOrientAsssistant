package academy.pocu.comp2500.assignment4;

import java.util.Objects;

public class Pixel {
    private char value;

    public Pixel() {
        this.value = 0x20;
    }

    public Pixel(char value) {
        if (value >= 0x20 && value <= 0x7E) {
            this.value = value;
        }
    }

    public void setValue(char value) {
        if (value >= 0x20 && value <= 0x7E) {
            this.value = value;
        }
    }

    public char getValue() {
        return this.value;
    }

    public boolean increase() {
        if (this.value == 0x7E) {
        } else if (value >= 0x20 && value < 0x7E) {
            this.value += 1;
            return true;
        }

        return false;
    }

    public boolean decrease() {
        if (this.value == 0x20) {
        } else if (value > 0x20 && value <= 0x7E) {
            this.value -= 1;
            return true;
        }
        return false;
    }

    public void toUpper() {
        if (this.value >= 0x61 && this.value <= 0x7A) {
            this.value ^= 0x20;
            return;
        }
    }

    public void toLower() {
        if (this.value >= 0x41 && this.value <= 0x5A) {
            this.value ^= 0x20;
        }
    }

    public void clear() {
        this.value = 0x20;
    }
}
