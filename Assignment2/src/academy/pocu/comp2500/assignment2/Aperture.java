package academy.pocu.comp2500.assignment2;

public class Aperture {
//    private final String value;
    private final Point position;
    private final int width;
    private final int height;
    public Aperture(int x, int y, int width, int height) {
//        this.value = aperture;
        this.position = new Point(x, y);
        this.width = width;
        this.height = height;
    }

//    public String getValue() {
//        return value;
//    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setPosition(int x, int y) {
        position.setX(x);
        position.setY(y);
    }
}
