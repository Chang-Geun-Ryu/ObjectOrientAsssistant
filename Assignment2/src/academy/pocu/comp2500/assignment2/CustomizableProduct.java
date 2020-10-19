package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class CustomizableProduct extends BaseProduct {

    private Orientation orientation;
    private ArrayList<Aperture> apertures;


    protected CustomizableProduct(Orientation orientation, ShippingMethod shippingMethod) {
        super(shippingMethod);
        this.orientation = orientation;
        this.apertures = new ArrayList<>();
//        this.textApertures = new ArrayList<>();
//        this.imageApertures = new ArrayList<>();
    }


    public Orientation getOrientation() {
        return this.orientation;
    }

    protected void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }


    public ArrayList<Aperture> getApertures() {
        return this.apertures;
    }


//    public ArrayList<ImageAperture> getImageApertures() {
//        return imageApertures;
//    }

//    public ArrayList<TextAperture> getTextApertures() {
//        return textApertures;
//    }

//    public boolean addTextAperture(TextAperture textAperture) {
//        int x = this.getSize().getWidth();
//        int y = this.getSize().getHeight();
//
//        if (textAperture.getWidth() + textAperture.getX() > 0
//                && textAperture.getHeight() + textAperture.getY() > 0
//                && textAperture.getX() < x
//                && textAperture.getY() < y) {
//            this.textApertures.add(textAperture);
//            this.addPrice(5);
//            return true;
//        }
//        return false;
//    }

//    public boolean addImageAperture(ImageAperture imageAperture) {
//        int x = this.getSize().getWidth();
//        int y = this.getSize().getHeight();
//
//        if (imageAperture.getWidth() + imageAperture.getX() > 0
//                && imageAperture.getHeight() + imageAperture.getY() > 0
//                && imageAperture.getX() < x
//                && imageAperture.getY() < y) {
//            this.imageApertures.add(imageAperture);
//            this.addPrice(5);
//            return true;
//        }
//
//        return false;
//    }


    public boolean addAperture(Aperture aperture) {
        int x = this.getSize().getWidth();
        int y = this.getSize().getHeight();

        if (aperture.getWidth() + aperture.getX() > 0
                && aperture.getHeight() + aperture.getY() > 0
                && aperture.getX() < x
                && aperture.getY() < y) {
            this.apertures.add(aperture);
            this.addPrice(5);
            return true;
        }

        return false;
    }


}
