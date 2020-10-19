package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomizableProduct extends Product {
    protected Orientation orientation;
    protected ArrayList<Aperture> apertures;

    protected CustomizableProduct(ShippingMethod shippingMethod, Orientation orientation) {
        super(shippingMethod);
        this.orientation = orientation;
        this.apertures = new ArrayList<>();
    }

    public enum Orientation {
        PORTRAIT,
        LANDSCAPE
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public ArrayList<Aperture> getApertures() {
        return this.apertures;
    }

    public int getApertureCount() {
        return this.apertures.size();
    }

    public void addAperture(Aperture aperture) {
//        boolean valid;
//        HashMap<Character, Integer> position = aperture.getPosition();
//        HashMap<String, Integer> size = aperture.getSize();
//
//        // check position
//        valid = (position.get('x') + size.get("length") > 0)
//                && (position.get('x') < super.length)
//                && (position.get('y') + size.get("height") > 0)
//                && (position.get('y') < super.height);
//
//        // add
//        if (valid) {
//            apertures.add(aperture);
//            super.price += 5;
//        }
        if (aperture == null) {
            return;
        }
        if (apertures.contains(aperture)) {
            return;
        }
        int posX = aperture.getX();
        if (!(-aperture.width < posX && posX < getLength())) {
            return;
        }
        int posY = aperture.getY();

        if (!(-aperture.height < posY && posY < getHeight())) {
            return;
        }

        price += 5;
        apertures.add(aperture);

    }
}
