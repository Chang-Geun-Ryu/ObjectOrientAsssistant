package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ApertureProduct extends Product {
    protected Orientation orientation;
    protected ArrayList<Aperture> apertures = new ArrayList<>();

    protected ApertureProduct(String displayName, Color color, int width, int height, int price, ShippingMethod shippingMethod, Orientation orientation) {
        super(displayName, color, width, height, price, shippingMethod);
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public ArrayList<Aperture> getApertures() {
        return apertures;
    }

    public void addTextAperture(TextAperture textAperture) {
        if (textAperture.isInvalid(width, height)) {
            return;
        }

        apertures.add(textAperture);
        super.price += 5;
    }

    public void addImageAperture(ImageAperture imageAperture) {
        if (imageAperture.isInvalid(width, height)) {
            return;
        }

        apertures.add(imageAperture);
        super.price += 5;
    }
}
