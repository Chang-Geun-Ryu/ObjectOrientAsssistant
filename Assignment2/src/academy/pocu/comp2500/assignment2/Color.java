package academy.pocu.comp2500.assignment2;

public class Color {
    private int r;
    private int g;
    private int b;

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
/*
    public Color(StampColor stampColor) {
        switch (stampColor) {
            case RED:
                this.r = 0xFF;
                this.g = 0x00;
                this.b = 0x00;
                break;
            case BLUE:
                this.r = 0x00;
                this.g = 0x00;
                this.b = 0xFF;
                break;
            case GREEN:
                this.r = 0x00;
                this.g = 0x80;
                this.b = 0x00;
                break;
        }
    }

    public Color(BusinessCardColor businessCardColor) {
        switch (businessCardColor) {
            case GRAY:
                this.r = 0xE6;
                this.g = 0xE6;
                this.b = 0xE6;
                break;
            case IVORY:
                this.r = 0xFF;
                this.g = 0xFF;
                this.b = 0xF0;
                break;
            case WHITE:
                this.r = 0xFF;
                this.g = 0xFF;
                this.b = 0xFF;
                break;
        }
    }
*/
    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }
}