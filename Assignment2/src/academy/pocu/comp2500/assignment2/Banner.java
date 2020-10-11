package academy.pocu.comp2500.assignment2;

public class Banner extends ApertureProduct {
    private BannerType type;

    public Banner(BannerType type, BannerSize bannerSize, Color color, Orientation orientation, DeliveryMethod deliveryMethod) {
        super(getSize(bannerSize), getPrice(bannerSize), color, orientation, deliveryMethod);
        this.type = type;
    }

    private static Size getSize(BannerSize bannerSize) {
        Size size = null;
        switch (bannerSize) {
            case SMALL:
                size = new Size(1000, 500);
                break;
            case MEDIUM:
                size = new Size(1000, 1000);
                break;
            case LARGE:
                size = new Size(2000, 500);
                break;
            case EXTRALARGE:
                size = new Size(3000, 1000);
                break;
        }
        return size;
    }

    static private int getPrice(BannerSize bannerSize) {
        int price = 0;
        switch (bannerSize) {
            case SMALL:
                price = 5000;
                break;
            case MEDIUM:
                price = 5200;
                break;
            case LARGE:
                price = 5300;
                break;
            case EXTRALARGE:
                price = 6000;
                break;
        }
        return price;
    }

    /*static private String getDisplayName(BannerType bannerType) {
        String name = "";
        switch (bannerType) {
            case GLOSS:
                name = "Gloss Banner";
                break;
            case SCRIM:
                name = "Scrim Banner";
                break;
            case MESH:
                name = "Mesh Banner";
                break;
        }
        return name;
    }*/

    public BannerType getType() {
        return type;
    }
}
