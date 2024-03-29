package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ApertureProduct extends Product {

    private ArrayList<Aperture> apertures = new ArrayList<>();

    protected ApertureProduct(Size size, Color color) {
        super(size, color, ShippingMethod.PICK_UP);
    }

    public void addAperture(Aperture aperture) {
        if (aperture.getX() >= 0 && aperture.getY() >= 0 && this.getSize().getWidth() >= aperture.getX() + aperture.getSize().getWidth() && this.getSize().getHeight() >= aperture.getY() + aperture.getSize().getHeight()) {
            this.apertures.add(aperture);
            this.setPrice(this.getPrice() + 5);
        }
    }

    public ArrayList<Aperture> getApertures() {
        return apertures;
    }
}
