package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ApertureProduct extends Product {
    protected ArrayList<TextAperture> textApertures = new ArrayList<>();
    protected ArrayList<ImageAperture> imageApertures = new ArrayList<>();
    private Orientation orientation;

    protected ApertureProduct(String type, int width, int height, Color color, int price, DeliveryMethod deliveryMethod, Orientation orientation) {
        super(type, width, height, color, price, deliveryMethod);
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public boolean addAperture(Aperture aperture) {
        if (isInAperture(aperture)) {
            if (aperture.getType().equals("text")) {
                this.textApertures.add((TextAperture) aperture);
            } else if (aperture.getType().equals("image")) {
                this.imageApertures.add((ImageAperture) aperture);
            }
            addPrice(5);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<TextAperture> getTextApertures() {
        return textApertures;
    }

    public ArrayList<ImageAperture> getImageApertures() {
        return imageApertures;
    }

    private boolean isInAperture(Aperture aperture) {
        return (0 <= aperture.getX() && aperture.getX() + aperture.getWidth() <= this.getWidth() && 0 <= aperture.getY() && aperture.getY() + aperture.getHeight() <= this.getHeight());
    }
}
