package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Banner extends ApertureProduct {
    private BannerType bannerType;
    private BannerSize bannerSize;
    private Color bannerColor;
//    public enum BannerType {
//        GLOSS_BANNER, SCRIM_BANNER, MESH_BANNER;
//    }
//
//    public enum BannerSize {
//        W100_H50, W100_H100, W200_H50, W300_H100;
//    }

    public Banner(BannerType bannerType, BannerSize bannerSize, Orientation orientation, Color color) {
        super();
        this.bannerType = bannerType;
        this.orientation = orientation;
        this.bannerColor = color;
        this.bannerSize = bannerSize;

        switch (bannerSize) {
            case W100_H50:
                super.size = new Size(1000, 500);
                super.price = 5000;
                break;
            case W100_H100:
                super.size = new Size(1000, 1000);
                super.price = 5200;
                break;
            case W200_H50:
                super.size = new Size(2000, 500);
                super.price = 5300;
                break;
            case W300_H100:
                super.size = new Size(3000, 1000);
                super.price = 6000;
                break;
        }

        // 세로 방향일 때, 가로 세로 변경
        if (orientation == Orientation.PORTRAIT) {
            int temp = size.getWidth();
            size.setWidth(size.getHeight());
            size.setHeight(temp);
        }

        super.color = color;

        switch (bannerType) {
            case GLOSS_BANNER:
                super.displayName = String.format("%s (%.0f mm x %.0f mm)", "Gloss Banner", super.size.getWidth(), super.size.getHeight());
                break;
            case SCRIM_BANNER:
                super.displayName = String.format("%s (%.0f mm x %.0f mm)", "Scrim Banner", super.size.getWidth(), super.size.getHeight());
                super.price += 100;
                break;
            case MESH_BANNER:
                super.displayName = String.format("%s (%.0f mm x %.0f mm)", "Mesh Banner", super.size.getWidth(), super.size.getHeight());
                super.price += 100;
                break;
        }
    }

    public BannerType getBannerType() {
        return bannerType;
    }

    public BannerSize getBannerSize() {
        return bannerSize;
    }

    public Color getBannerColor() {
        return bannerColor;
    }
}
