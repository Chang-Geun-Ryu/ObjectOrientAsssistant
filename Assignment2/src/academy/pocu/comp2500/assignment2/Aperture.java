package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Aperture {
    protected String text;
//    private int x;
//    private int y;
//    private int width;
//    private int height;

    protected ArrayList<Integer> elements;

    protected Aperture() {
//        this.text = text;
//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.height = height;
//        this.elements = new ArrayList<Integer>();
    }

    public String getText() {
        return text;
    }

    protected void setText(String text) {
        this.text = text;
    }

    protected void setElement(ArrayList<Integer> elements) {
        this.elements = elements;
    }

    public ArrayList<Integer> getElements() {
        return this.elements;
    }
}
