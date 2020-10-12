package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class CustomizingProduct extends Product {
    private Orientation orientation;
    private ArrayList<Aperture> apertures;

    protected CustomizingProduct() {
        this.apertures = new ArrayList<>();
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public ArrayList<Aperture> getApertures() {
        return apertures;
    }

    protected void setOrientation(Orientation orientation) {
//        if ((this.orientation == null && orientation == Orientation.PORTRAIT) || this.orientation != orientation) {
//            int temp = super.getWidth();
//            super.setWidth(super.getHeight());
//            super.setHeight(temp);
//        }
        this.orientation = orientation;
    }

    public void addAperture(Aperture aperture) {
        int printEndX = aperture.getX() + aperture.getWidth();
        int printEndY = aperture.getY() + aperture.getHeight();
        boolean canPrint = true;
        if (aperture.getWidth() <= 0 || aperture.getHeight() <= 0) {
            canPrint = false;
        } else if (aperture.getX() <= 0 && printEndX <= 0) {
            canPrint = false;
        } else if (aperture.getX() >= super.getWidth()) {
            canPrint = false;
        } else if (aperture.getY() <= 0 && printEndY <= 0) {
            canPrint = false;
        } else if (aperture.getY() >= super.getHeight()) {
            canPrint = false;
        }
        if (canPrint == true) {
            this.apertures.add(aperture);
            super.setPrice(super.getPrice() + 5);
        }
    }
}
