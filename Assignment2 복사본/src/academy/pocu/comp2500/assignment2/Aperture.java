package academy.pocu.comp2500.assignment2;

public class Aperture {
    private String typeName;
    private int x;
    private int y;
    private int width;
    private int height;

    protected Aperture(String typeName, int x, int y, int width, int height) {
        this.typeName = typeName;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public String getTypeName() {
        return this.typeName;
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
