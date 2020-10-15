package academy.pocu.comp2500.assignment2;

public class Size {
    private int height;
    private int width;

    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getHeigth() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isEquals(Size size) {
        return this.width == size.width && this.height == size.height;
    }
}
