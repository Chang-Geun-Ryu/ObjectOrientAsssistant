package academy.pocu.comp2500.assignment2;

public class Banner extends OrientationProduct {
    private BannerMaterial bannerMaterial;

    public BannerMaterial getBannerMaterial() {
        return bannerMaterial;
    }

    public Banner(Orientation orientation, RGB color, BannerMaterial bannerMaterial, BannerSize bannerSize) {
        this.bannerMaterial = bannerMaterial;
        this.orientation = orientation;
        this.color = color;

        switch (bannerSize) {
            case SIZE_100X50:
                size = new Size(1000, 500);
                switch (bannerMaterial) {
                    case GLOSS:
                        price = 5000;
                        break;
                    case MESH:
                        price = 5100;
                        break;
                    case SCRIM:
                        price = 5100;
                        break;
                }
                break;
            case SIZE_100X100:
                size = new Size(1000, 1000);

                switch (bannerMaterial) {
                    case GLOSS:
                        price = 5200;
                        break;
                    case MESH:
                        price = 5300;
                        break;
                    case SCRIM:
                        price = 5300;
                        break;
                }
                break;
            case SIZE_200X50:
                size = new Size(2000, 500);

                switch (bannerMaterial) {
                    case GLOSS:
                        price = 5300;
                        break;
                    case MESH:
                        price = 5400;
                        break;
                    case SCRIM:
                        price = 5400;
                        break;

                }
                break;
            case SIZE_300X100:
                size = new Size(3000, 1000);

                switch (bannerMaterial) {
                    case GLOSS:
                        price = 6000;
                        break;
                    case MESH:
                        price = 6100;
                        break;
                    case SCRIM:
                        price = 6100;
                        break;
                }
                break;
        }


        switch (bannerMaterial) {
            case SCRIM:
                displayName = "Scrim Banner";
                break;
            case MESH:
                displayName = "Mesh Banner";
                break;
            case GLOSS:
                displayName = "Gloss Banner";
                break;
        }

        displayName += " (" + getSize().getWidth() + "mm x " + getSize().getHeight() + "mm)";
    }
}
