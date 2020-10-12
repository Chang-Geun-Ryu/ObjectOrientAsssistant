package academy.pocu.comp2500.assignment2;

public class RGB {
    private int r;
    private int g;
    private int b;

    public RGB(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getIntRGB() {
        return (r << 16) + (g << 8) + b;
    }
}
