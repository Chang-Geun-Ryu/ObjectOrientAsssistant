package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ApertureProduct extends Product {
    private Orientation orientation;
    private ArrayList<ImageAperture> imageApertures;
    private ArrayList<TextAperture> textApertures;

    public ApertureProduct(Size size, int price, Color color, Orientation orientation, DeliveryMethod deliveryMethod) {
        super(size, price, color, deliveryMethod);
        this.orientation = orientation;
        imageApertures = new ArrayList<>();
        textApertures = new ArrayList<>();
    }

    public void addImage(ImageAperture imageAperture) {
        if (imageAperture.getX() + imageAperture.getSize().getWidth() <= 0 ||
                imageAperture.getX() >= super.size.getWidth()) {
            return;
        }

        if (imageAperture.getY() + imageAperture.getSize().getHeigth() <= 0 ||
                imageAperture.getY() >= super.size.getHeigth()) {
            return;
        }

        super.price += 5;
        imageApertures.add(imageAperture);
    }

    public void addText(TextAperture textAperture) {
        if (textAperture.getX() + textAperture.getSize().getWidth() <= 0 ||
                textAperture.getX() >= super.size.getWidth()) {
            return;
        }

        if (textAperture.getY() + textAperture.getSize().getHeigth() <= 0 ||
                textAperture.getY() >= super.size.getHeigth()) {
            return;
        }

        super.price += 5;
        textApertures.add(textAperture);
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public ArrayList<ImageAperture> getImageApertures() {
        return imageApertures;
    }

    public ArrayList<TextAperture> getTextApertures() {
        return textApertures;
    }
}
