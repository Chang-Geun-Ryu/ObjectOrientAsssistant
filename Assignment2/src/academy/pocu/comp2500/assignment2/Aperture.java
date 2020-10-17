package academy.pocu.comp2500.assignment2;

public class Aperture {
    private final String value;
    private final Point position;

    public Aperture(String aperture, int x, int y) {
        this.value = aperture;
        this.position = new Point(x, y);
    }

    public String getValue() {
        return value;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public void setPosition(int x, int y) {
        position.setX(x);
        position.setY(y);
    }
}
