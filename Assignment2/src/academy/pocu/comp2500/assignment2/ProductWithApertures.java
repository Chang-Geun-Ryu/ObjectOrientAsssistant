package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ProductWithApertures extends Product {
    private ArrayList<String> imageApertures;
    private ArrayList<String> textApertures;
    private Orientation orientation;

    enum Orientation {
        PORTRAIT,
        LANDSCAPE
    }

    public ProductWithApertures(int red, int green, int blue, int width, int height, int price, Orientation orientation, ShippingMethod shippingMethod) {
        super(red, green, blue, width, height, price, shippingMethod);

        this.imageApertures = new ArrayList<String>();
        this.textApertures = new ArrayList<String>();
        this.orientation = orientation;
    }

    public void addImageAperture(String imageAperture) {
        this.imageApertures.add(imageAperture);
        super.price += 5;
    }

    public void addTextAperture(String textAperture) {
        this.textApertures.add(textAperture);
        super.price += 5;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public ArrayList<String> getImageApertures() {
        return this.imageApertures;
    }

    public ArrayList<String> getTextApertures() {
        return this.textApertures;
    }
}
