package academy.pocu.comp2500.assignment2;

// 단위 : mm
public class Size {

    private int width;
    private int height;

    public Size() {
    }

    public Size(int width, int height) {
        this.width = Math.min(Math.max(0, width), width);
        this.height = Math.min(Math.max(0, height), height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
