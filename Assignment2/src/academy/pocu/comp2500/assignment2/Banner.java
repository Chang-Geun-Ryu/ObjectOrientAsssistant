package academy.pocu.comp2500.assignment2;

public class Banner extends CustomizableProduct {

    private BannerMaterial bannerMaterial;
    private BannerSize bannerSize;

    public Banner(Color color, Orientation orientation, BannerMaterial bannerMaterial, BannerSize bannerSize, ShippingMethod shippingMethod) {
        super(orientation, shippingMethod);
        super.setColor(color);

        this.bannerSize = bannerSize;
//        int[] sizes = this.getBannerSizeValues(bannerSize);
//        Size size = new Size(sizes[0], sizes[1]);
//        super.setSize(size);


        this.bannerMaterial = bannerMaterial;
        switch (bannerSize) {
            case ONE_BY_HALF:
                setSize(new Size(1000, 500));
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
            case ONE_BY_ONE:
                setSize(new Size(1000, 1000));

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
            case TWO_BY_HALF:
                setSize(new Size(2000, 500));

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
            case TREE_BY_ONE:
                setSize(new Size(3000, 1000));

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


    private int[] getBannerSizeValues(BannerSize bannerSize) {
        int[] sizeInfo = new int[2];
        switch (bannerSize) {
            case ONE_BY_HALF:
                sizeInfo[0] = 1000;
                sizeInfo[1] = 500;
                break;
            case ONE_BY_ONE:
                sizeInfo[0] = 1000;
                sizeInfo[1] = 1000;
                break;
            case TWO_BY_HALF:
                sizeInfo[0] = 2000;
                sizeInfo[1] = 500;
                break;
            case TREE_BY_ONE:
                sizeInfo[0] = 3000;
                sizeInfo[1] = 1000;
                break;
        }
        return sizeInfo;
    }

//    public BannerSize getBannerSize() {
//        return this.bannerSize;
//    }

    public BannerMaterial getBannerMaterial() {
        return bannerMaterial;
    }

}
