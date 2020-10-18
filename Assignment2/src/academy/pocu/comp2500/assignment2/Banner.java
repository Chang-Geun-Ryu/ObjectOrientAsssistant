package academy.pocu.comp2500.assignment2;

public class Banner extends ProductWithApertures {
    enum BannerType {
        GLOSS,
        SCRIM,
        MESH
    }

    enum BannerSize {
        W100H50,
        W100H100,
        W200H50,
        W300H100
    }

    private BannerType bannerType;

    public Banner(int red, int green, int blue, BannerSize bannerSize, BannerType bannerType, Orientation orientation, ShippingMethod shippingMethod) {
        super(red, green, blue, getWidth(bannerSize), getHeight(bannerSize), getPrice(bannerType, bannerSize), orientation, shippingMethod);

        this.bannerType = bannerType;
    }

    private static int getWidth(BannerSize bannerSize) {
        if (bannerSize == BannerSize.W100H50 || bannerSize == BannerSize.W100H100) {
            return 1000;
        } else if (bannerSize == BannerSize.W200H50) {
            return 2000;
        } else {
            return 3000;
        }
    }

    private static int getHeight(BannerSize bannerSize) {
        if (bannerSize == BannerSize.W100H50 || bannerSize == BannerSize.W200H50) {
            return 500;
        } else {
            return 1000;
        }
    }

    private static int getPrice(BannerType bannerType, BannerSize bannerSize) {
        if (bannerType == BannerType.GLOSS) {
            if (bannerSize == BannerSize.W100H50) {
                return 5000;
            } else if (bannerSize == BannerSize.W100H100) {
                return 5200;
            } else if (bannerSize == BannerSize.W200H50) {
                return 5300;
            } else {
                return 6000;
            }
        } else {
            if (bannerSize == BannerSize.W100H50) {
                return 5100;
            } else if (bannerSize == BannerSize.W100H100) {
                return 5300;
            } else if (bannerSize == BannerSize.W200H50) {
                return 5400;
            } else {
                return 6100;
            }
        }
    }

    public BannerType getBannerType() {
        return bannerType;
    }
}
