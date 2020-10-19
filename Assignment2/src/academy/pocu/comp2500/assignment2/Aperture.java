package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Aperture {

    private Size size;
    private Position position;
    private ArrayList<Side> sides;

    protected Aperture(int width, int height, int x, int y) {
        this.size = new Size(width, height);
        this.position = new Position(x, y);
        this.sides = new ArrayList<>();

        this.sides.add(new Side(x, y + height));
        this.sides.add(new Side(x, y));
        this.sides.add(new Side(x + width, y + height));
        this.sides.add(new Side(x + width, y));
    }

    public int getWidth() {
        return size.getWidth();
    }

    public int getHeight() {
        return size.getHeight();
    }

    public int getX() {
        return this.position.getX();
    }

    public int getY() {
        return this.position.getY();
    }

    public ArrayList<Side> getSides() {
        return sides;
    }
    //    public void setX(int x) {
//        this.position.setX(x);
//    }
//    public void setY(int y) {
//        this.position.setY(y);
//    }


}
