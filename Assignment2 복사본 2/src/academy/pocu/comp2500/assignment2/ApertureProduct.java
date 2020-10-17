package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ApertureProduct extends Product {
    protected Orientation orientation;
    protected ArrayList<TextAperture> texts = new ArrayList<>();
    protected ArrayList<ImageAperture> imagePath = new ArrayList<>();

    protected ApertureProduct(Orientation orientation, Delivery delivery) {
        super(delivery);
        this.orientation = orientation;
    }

    public void addText(TextAperture textAperture) {
        if (textAperture != null && textAperture.isTextCorrect(this)) {
            this.texts.add(textAperture);
            price += 5;
        }
    }

    public void addImagePath(ImageAperture imageAperture) {
        if (imageAperture != null && imageAperture.isImageCorrect(this)) {
            this.imagePath.add(imageAperture);
            price += 5;
        }
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public ArrayList<TextAperture> getTexts() {
        return texts;
    }

    public ArrayList<ImageAperture> getImagePath() {
        return imagePath;
    }
}
