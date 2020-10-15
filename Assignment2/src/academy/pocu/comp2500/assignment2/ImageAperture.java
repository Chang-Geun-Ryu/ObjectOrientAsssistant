package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ImageAperture extends Aperture {
    public ImageAperture(String imagePath, int x, int y, int width, int height) {
        super();
        setText(imagePath);

        ArrayList<Integer> elements = new ArrayList<Integer>();
        elements.add(x);
        elements.add(y);
        elements.add(width);
        elements.add(height);

        setElement(elements);
    }

//    public String getText() {
//        return super.text;
//    }

//    public int getX() {
//        return super.elements.get(0);
//    }
//
//    public int getY() {
//        return super.elements.get(1);
//    }
//
//    public int getWidth() {
//        return super.elements.get(2);
//    }
//
//    public int getHeight() {
//        return super.elements.get(3);
//    }

//    public String getImagePath() {
//        return super.text;
//    }

//    public void setImagePath(String imagePath) {
//        this.text = imagePath;
//    }
}
