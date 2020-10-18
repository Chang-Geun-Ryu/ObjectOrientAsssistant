package academy.pocu.comp2500.assignment2;

public class Size {
    private int width, height;
    public Size(int width, int height) {
        this.width = Math.max(1, width);
        this.height = Math.max(1, height);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
