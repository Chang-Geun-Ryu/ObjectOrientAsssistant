package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Banner extends ApertureProduct {
    private int addPriceBySize = 0;

    private BannerType bannerType;
    private BannerSize bannerSize;


    public Banner(BannerType bannerType, BannerSize bannerSize, Color color, Orientation orientation, DeliveryMethod deliveryMethod) {
        super("Banner", 0, 0, color, 5000, deliveryMethod, orientation);
        setBannerType(bannerType);
        setBannerSize(bannerSize);
    }

    public BannerSize getBannerSize() {
        return bannerSize;
    }

    public BannerType getBannerType() {
        return bannerType;
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
}
