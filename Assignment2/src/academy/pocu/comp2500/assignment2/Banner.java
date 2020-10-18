package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Banner extends Product {
//    private ArrayList<TextAperture> textApertures = new ArrayList<>();
//    private ArrayList<ImageAperture> imageApertures = new ArrayList<>();
    private  ArrayList<Aperture> apertures = new ArrayList<>();
    private int addPriceBySize = 0;

    private Orientation orientation;
    private BannerType bannerType;
    private BannerSize bannerSize;


    public Banner(BannerType bannerType, BannerSize bannerSize, Color color, Orientation orientation, DeliveryMethod deliveryMethod) {
        super("Banner", 0, 0, color, 5000, deliveryMethod);
        this.orientation = orientation;
        setBannerType(bannerType);
        setBannerSize(bannerSize);
    }

    private void setBannerSize(BannerSize bannerSize) {
        addPrice(-addPriceBySize);
        this.addPriceBySize = 0;
        this.bannerSize = bannerSize;
        if (this.bannerSize == BannerSize.SIZE1000X500) {
            setWidth(1000);
            setHeight(500);
        } else if (this.bannerSize == BannerSize.SIZE1000X1000) {
            setWidth(1000);
            setHeight(1000);
            this.addPriceBySize = 200;
        } else if (this.bannerSize == BannerSize.SIZE2000X500) {
            setWidth(2000);
            setHeight(500);
            this.addPriceBySize = 100;
        } else if (this.bannerSize == BannerSize.SIZE3000X1000) {
            setWidth(3000);
            setHeight(1000);
            this.addPriceBySize = 700;
        }
        addPrice(addPriceBySize);
    }

    private void setBannerType(BannerType bannerType) {
        this.bannerType = bannerType;
        if (this.bannerType == BannerType.GLOSS) {
            setDisplayName("Gloss Banner");
        } else if (this.bannerType == BannerType.SCRIM) {
            setDisplayName("Scrim Banner");
            addPrice(100);
        } else if (this.bannerType == BannerType.MESH) {
            setDisplayName("Mesh Banner");
            addPrice(100);
        }
    }
    public boolean addAperture(Aperture aperture) {
        if (isInAperture(aperture)) {
            this.apertures.add(aperture);
            addPrice(5);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Aperture> getApertures() {
        return  apertures;
    }

//    public boolean addTextAperture(TextAperture textAperture) {
//        if (isInAperture(textAperture)) {
//            this.textApertures.add(textAperture);
//            addPrice(5);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public boolean addImageAperture(ImageAperture imageAperture) {
//        if (isInAperture(imageAperture)) {
//            this.imageApertures.add(imageAperture);
//            addPrice(5);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public ArrayList<TextAperture> getTextApertures() {
//        return textApertures;
//    }
//
//    public ArrayList<ImageAperture> getImageApertures() {
//        return imageApertures;
//    }

    public Orientation getOrientation() {
        return orientation;
    }

    private boolean isInAperture(Aperture aperture) {
        return (0 <= aperture.getX() && aperture.getX() + aperture.getWidth() <= this.getWidth() && 0 <= aperture.getY() && aperture.getY() + aperture.getHeight() <= this.getHeight());
    }
}
