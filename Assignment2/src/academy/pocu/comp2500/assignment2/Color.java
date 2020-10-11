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

    public int getR() {
        return r;
    }

    public int getB() {
        return b;
    }

    public int getG() {
        return g;
    }

    public boolean isEquals(Color color) {
        return this.r == color.r && this.g == color.g && this.b == color.b;
    }

}
