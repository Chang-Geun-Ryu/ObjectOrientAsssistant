package academy.pocu.comp2500.assignment2;

import java.util.HashMap;

public class Aperture {
    protected ApertureType type;
    protected String aperture;
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    protected Aperture(int x, int y, int length, int height) {
        this.x = x;
        this.y = y;
        this.width = length;
        this.height = height;
    }

    public enum ApertureType {
        TEXT,
        IMAGE
    }

    public ApertureType getType() {
        return this.type;
    }

    public String getAperture() {
        return this.aperture;
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
        return  height;
    }
//    public HashMap<Character, Integer> getPosition() {
//        HashMap<Character, Integer> position = new HashMap<>();
//        position.put('x', this.x);
//        position.put('y', this.y);
//
//        return position;
//    }
//
//    public HashMap<String, Integer> getSize() {
//        HashMap<String, Integer> size = new HashMap<>();
//        size.put("length", this.length);
//        size.put("height", this.height);
//
//        return size;
//    }
}
