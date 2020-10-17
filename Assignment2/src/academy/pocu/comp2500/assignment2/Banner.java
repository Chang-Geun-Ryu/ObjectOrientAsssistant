package academy.pocu.comp2500.assignment2;

public class Banner extends ApertureProduct {
    private BannerType bannerType;

    public Banner(BannerType bannerType, Color color, BannerSize size, Orientation orientation, ShippingMethod shippingMethod) {
        super("Banner", color, 0, 0, 0, shippingMethod, orientation);

        this.bannerType = bannerType;

        switch (size) {
            case MM1000X500:
                super.width = 1000;
                super.height = 500;
                super.price = 5100;
                break;
            case MM1000X1000:
                super.width = 1000;
                super.height = 1000;
                super.price = 5300;
                break;
            case MM2000X500:
                super.width = 2000;
                super.height = 500;
                super.price = 5400;
                break;
            case MM3000X1000:
                super.width = 3000;
                super.height = 1000;
                super.price = 6100;
                break;
        }

        switch (bannerType) {
            case GLOSS:
                super.displayName = String.format("Gloss Banner (%d mm x %d mm)", super.width, super.height);
                super.price -= 100;
                break;
            case SCRIM:
                super.displayName = String.format("Scrim Banner (%d mm x %d mm)", super.width, super.height);
                break;
            case MESH:
                super.displayName = String.format("Mesh Banner (%d mm x %d mm)", super.width, super.height);
                break;
        }
    }

    public BannerType getBannerType() {
        return bannerType;
    }
}
