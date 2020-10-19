package academy.pocu.comp2500.assignment2;

public class Color {
    private int r;
    private int g;
    private int b;

    public Color(int red, int green, int blue) {

        this.r = Math.min(Math.max(0, r), 0xff);
        this.g = Math.min(Math.max(0, g), 0xff);
        this.b = Math.min(Math.max(0, b), 0xff);
    }

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
