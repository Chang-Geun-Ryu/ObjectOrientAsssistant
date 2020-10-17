package academy.pocu.comp2500.assignment2;

public class Aperture {
    protected int width;
    protected int height;
    protected int x;
    protected int y;

    protected Aperture(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    protected boolean isApertureCorrect(Product product) {
        return x >= 0 && y >= 0 && x + this.width < product.width && this.y + this.height < product.height;
    }
}
