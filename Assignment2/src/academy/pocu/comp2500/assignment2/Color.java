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

    protected Color(String color) {
        switch (color) {
            case "RED":
                this.r = 0xFF;
                this.g = 0x00;
                this.b = 0x00;
                break;
            case "BLUE":
                this.r = 0x00;
                this.g = 0x00;
                this.b = 0xFF;
                break;
            case "GREEN":
                this.r = 0x00;
                this.g = 0x80;
                this.b = 0x00;
                break;
            case "WHITE":
                this.r = 0xFF;
                this.g = 0xFF;
                this.b = 0xFF;
                break;
            case "GRAY":
                this.r = 0xE6;
                this.g = 0xE6;
                this.b = 0xE6;
                break;
            case "IVORY":
                this.r = 0xFF;
                this.g = 0xFF;
                this.b = 0xF0;
                break;
            default:
                this.r = 0x00;
                this.g = 0x00;
                this.b = 0x00;
                break;
        }
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public boolean equalsTo(int r, int g, int b) {
        return (this.r == r && this.g == g && this.b == b);
    }
}
