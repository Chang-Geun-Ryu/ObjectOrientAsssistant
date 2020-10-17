package academy.pocu.comp2500.assignment2;

public class Banner extends ApertureProduct {
    private BannerType bannerType;
    private BannerSize bannerSize;

    public Banner(BannerType bannerType, BannerSize bannerSize,
                  Orientation orientation, short r, short g, short b, Delivery delivery) {
        super(orientation, delivery);
        super.r = r;
        super.g = g;
        super.b = b;
        this.bannerType = bannerType;
        this.bannerSize = bannerSize;

        switch (bannerType) {
            case GLOSS: {
                super.name = "Gloss";
                super.price = 5000;
                break;
            }
            case SCRIM: {
                super.name = "Scrim";
                super.price = 5100;
            }
            case MESH: {
                super.name = "Mesh";
                super.price = 5100;
                break;
            }
            default: {
                assert (false) : "Enum Error";
            }
        }

        switch (bannerSize) {
            case MM1000X500: {
                super.width = 1000;
                super.height = 500;
                break;
            }
            case MM1000X1000: {
                super.width = 1000;
                super.height = 1000;
                super.price += 200;
                break;
            }
            case MM2000X500: {
                super.width = 2000;
                super.height = 500;
                super.price += 300;
                break;
            }
            case MM3000X1000: {
                super.width = 3000;
                super.height = 1000;
                super.price += 1000;
                break;
            }
            default: {
                assert (false) : "Enum Error";
            }
        }

        super.name += String.format("Banner (%s mm x %s mm)", super.width, super.height);
    }

    public BannerType getBannerType() {
        return bannerType;
    }

    public BannerSize getBannerSize() {
        return bannerSize;
    }
}