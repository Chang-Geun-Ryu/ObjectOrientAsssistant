package academy.pocu.comp2500.assignment2;

public class Color {
    private int r;
    private int g;
    private int b;

//    protected Color() {
//    }

    public Color(int r, int g, int b) {
        this.r = r;//Math.min(Math.max(0, r), 0xFF);
        this.g = g;//Math.min(Math.max(0, g), 0xFF);
        this.b = b;//Math.min(Math.max(0, b), 0xFF);
    }

//    public int getR() {
//        return r;
//    }
//
//    public void setR(int r) {
//        this.r = r;
//    }
//
//    public int getG() {
//        return g;
//    }
//
//    public void setG(int g) {
//        this.g = g;
//    }
//
//    public int getB() {
//        return b;
//    }
//
//    public void setB(int b) {
//        this.b = b;
//    }

    public int getIntColor() {
        return (r << 16) + (g << 8) + b;
    }
}
