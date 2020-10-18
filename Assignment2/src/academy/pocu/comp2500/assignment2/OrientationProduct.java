package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class OrientationProduct extends Product {
    protected Orientation orientation;
    protected ArrayList<Aperture> apertures;


    public ArrayList<Aperture> getApertures() {
        return apertures;
    }

    protected OrientationProduct() {
        apertures = new ArrayList<>();
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void addAperture(Aperture aperture) {
        if (aperture == null) {
            return;
        }
        if (apertures.contains(aperture)) {
            return;
        }
        int posX = aperture.getX();
        if (!(-aperture.width < posX && posX < getSize().getWidth())) {
            return;
        }
        int posY = aperture.getY();

        if (!(-aperture.height < posY && posY < getSize().getHeight())) {
            return;
        }

        price += 5;
        apertures.add(aperture);
    }

}
