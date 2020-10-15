package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ApertureProduct extends Product {
    protected Orientation orientation;
    protected ArrayList<Aperture> apertures = new ArrayList<Aperture>();

    public enum Orientation {
        PORTRAIT, LANDSCAPE;
    }

    protected ApertureProduct(String productId) {
        super(productId);
    }

    public void addAperture(Aperture aperture) {
//        if (aperture.x < 0 || aperture.x + aperture.width > super.size.getWidth() || aperture.y < 0 || aperture.y + aperture.height > super.size.getHeight()) {
//            return;
//        }
        if (aperture.x + aperture.width <= 0 || aperture.x >= aperture.width || aperture.y + aperture.height <= 0 || aperture.y >= aperture.height) {
            return;
        }
        this.apertures.add(aperture);
        super.price += 5;
    }

    public ArrayList<Aperture> getAperture() {
        return apertures;
    }

    public Orientation getOrientation() {
        return orientation;
    }

}
