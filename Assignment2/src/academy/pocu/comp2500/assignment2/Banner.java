package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Banner extends ApertureProduct {

    private EBannerType bannerType;
    private EBannerSize bannerSize;

    public Banner(EBannerType bannerType, EBannerSize bannerSize, int r, int g, int b, EOrientation orientation, EShippingMethod shippingMethod) {
        super(orientation, shippingMethod);
        imageApertures = new ArrayList<>();
        textApertures = new ArrayList<>();
        this.orientation = orientation;
        this.bannerType = bannerType;
        this.bannerSize = bannerSize;
        color = new Color(r, g, b);

        switch (bannerSize) {
            case ONE_HALF:
                setDetailSize(1000, 500);
                price = 5000;
                break;
            case ONE_ONE:
                demension = new Demension(1000, 1000);
                price = 5200;
                break;
            case TWO_HALF:
                setDetailSize(2000, 500);
                price = 5300;
                break;
            case THREE_ONE:
                setDetailSize(3000, 1000);
                price = 6000;
                break;
            default:
                assert false;
        }
        if (bannerType != EBannerType.GLOSS) {
            price += 100;
        }
    }

    public EBannerType getBannerType() {
        return bannerType;
    }

    private void setDetailSize(int sizeOne, int sizeTwo) {
        if (orientation == EOrientation.PORTRAIT && sizeOne > sizeTwo
                || orientation == EOrientation.LANDSCAPE && sizeOne < sizeTwo) {
            demension = new Demension(sizeTwo, sizeOne);
        } else {
            demension = new Demension(sizeOne, sizeTwo);
        }
    }
}
