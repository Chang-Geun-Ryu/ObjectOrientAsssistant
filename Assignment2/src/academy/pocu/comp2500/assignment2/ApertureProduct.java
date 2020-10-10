package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ApertureProduct extends BaseProduct {

    protected EOrientation orientation;
    protected ArrayList<ImageAperture> imageApertures = new ArrayList<>();
    protected ArrayList<TextAperture> textApertures = new ArrayList<>();

    ApertureProduct(EOrientation orientation, EShippingMethod shippingMethod) {
        super(shippingMethod);
        this.orientation = orientation;
    }

    public void addImageAperture(ImageAperture imageAperture) {
        if (0 < imageAperture.getX()
                && imageAperture.getX() + imageAperture.getDemension().getWidth() < demension.getWidth()
                && 0 < imageAperture.getY()
                && imageAperture.getY() + imageAperture.getDemension().getHeight() < demension.getHeight()) {
            imageApertures.add(imageAperture);
            price += 5;
        }
    }

    public void addTextAperture(TextAperture textAperture) {
        if (0 < textAperture.getX()
                && textAperture.getX() + textAperture.getDemension().getWidth() < demension.getWidth()
                && 0 < textAperture.getY()
                && textAperture.getY() + textAperture.getDemension().getHeight() < demension.getHeight()) {
            textApertures.add(textAperture);
            price += 5;
        }
    }

    public EOrientation getOrientation() {
        return orientation;
    }
}
