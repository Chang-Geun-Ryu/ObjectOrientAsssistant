package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ProductWithImage extends Product {
    private Orientation orientation;
    private ArrayList<Aperture> apertures;

    public ProductWithImage(String type, Color color, Size size, int price, Orientation orientation, ShippingMethod shippingMethod) {
        super(type, color, size, price, shippingMethod);

        this.orientation = orientation;
        this.apertures = new ArrayList<>();
    }

    public Orientation getOrientation() {
        return orientation;
    }

    private boolean isProperPosition(int x, int y) {
        if (!(x >= 0 && x < this.getWidth())) {
            return false;
        }

        if (!(y >= 0 && y < this.getHeight())) {
            return false;
        }

        return true;
    }

//    public void setAperturePosition(Aperture aperture, int x, int y) {
//        if (!isProperPosition(x, y)) {
//            return;
//        }
//
//        for (Aperture one : this.apertures) {
//            if (one.getValue().equals(aperture.getValue())) {
//                one.setPosition(x, y);
//                return;
//            }
//        }
//    }

    public void addAperture(Aperture aperture) {
        if (aperture == null || isProperPosition(aperture.getX(), aperture.getY()) != true) {
            return;
        }

        this.apertures.add(new Aperture(aperture.getValue(), aperture.getX(), aperture.getY()));
        super.setPrice(super.getPrice() + 5);
    }
}