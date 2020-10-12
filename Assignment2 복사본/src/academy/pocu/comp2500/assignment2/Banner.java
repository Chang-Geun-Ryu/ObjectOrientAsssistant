package academy.pocu.comp2500.assignment2;

public class Banner extends CustomizingProduct {
    private BannerType bannerType;
    private BannerSize bannerSize;

    public Banner(int r, int g, int b, BannerType bannerType, BannerSize bannerSize, Orientation orientation) {
        super.setRGB(new RGB(r, g, b));
        this.bannerType = bannerType;
        setBannerSize(bannerSize);
        super.setOrientation(orientation);
    }

    private void setName() {
        super.setName(String.format("%s Banner (%d mm x %d mm)", this.bannerType.getName(), super.getWidth(), super.getHeight()));
    }

    private void calculatePrice() {
        int calculate = 0;
        if (super.getWidth() >= 3000) {
            calculate = 6100;
        } else if (super.getWidth() >= 2000) {
            calculate = 5400;
        } else {
            if (super.getHeight() >= 1000) {
                calculate = 5300;
            } else {
                calculate = 5100;
            }
        }
        if (this.bannerType == BannerType.GLOSS) {
            calculate -= 100;
        }
        calculate += (5 * super.getApertures().size());
        super.setPrice(calculate);
    }

    public BannerType getBannerType() {
        return this.bannerType;
    }

    public BannerSize getBannerSize() {
        return this.bannerSize;
    }

    private void setBannerType(BannerType bannerType) {
        this.bannerType = bannerType;
        setName();
        calculatePrice();
    }

    private void setBannerSize(BannerSize bannerSize) {
        this.bannerSize = bannerSize;
        super.setWidth(bannerSize.getWidth());
        super.setHeight(bannerSize.getHeight());
        setName();
        calculatePrice();
    }
}
