package academy.pocu.comp2500.assignment2;

public class Aperture {
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    protected Aperture(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isInvalid(int width, int height) {
        return x < 0 || y < 0 || x + this.width > width || y + this.height > height;
    }
}
