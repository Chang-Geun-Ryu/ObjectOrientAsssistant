package academy.pocu.comp2500.assignment2;

public class Banner extends CustomizableProduct {

    private BannerMaterial bannerMaterial;
    private BannerSize bannerSize;

    public Banner(Color color, Orientation orientation, BannerMaterial bannerMaterial, BannerSize bannerSize, ShippingMethod shippingMethod) {
        super(orientation, shippingMethod);
        super.setColor(color);

        this.bannerSize = bannerSize;
        int[] sizes = this.getBannerSizeValues(bannerSize);
        Size size = new Size(sizes[0], sizes[1]);
        super.setSize(size);


        this.bannerMaterial = bannerMaterial;
        switch (bannerSize) {
            case ONE_BY_HALF:
                switch (bannerMaterial) {
                    case SCRIM:
                        super.setDisplayName("Scrim Banner (1000 mm x 500 mm)");
                        super.addPrice(5100);
                        break;
                    case MESH:
                        super.setDisplayName("Mesh Banner (1000 mm x 500 mm)");
                        super.addPrice(5100);
                        break;
                    case GLOSS:
                        super.setDisplayName("Gloss Banner (1000 mm x 500 mm)");
                        super.addPrice(5000);
                        break;
                }
                break;
            case ONE_BY_ONE:
                switch (bannerMaterial) {
                    case SCRIM:
                        super.setDisplayName("Scrim Banner (1000 mm x 1000 mm)");
                        super.addPrice(5300);
                        break;
                    case MESH:
                        super.setDisplayName("Mesh Banner (1000 mm x 1000 mm)");
                        super.addPrice(5300);
                        break;
                    case GLOSS:
                        super.setDisplayName("Gloss Banner (1000 mm x 1000 mm)");
                        super.addPrice(5200);
                        break;
                }
                break;
            case TWO_BY_HALF:
                switch (bannerMaterial) {
                    case SCRIM:
                        super.setDisplayName("Scrim Banner (2000 mm x 500 mm)");
                        super.addPrice(5400);
                        break;
                    case MESH:
                        super.setDisplayName("Mesh Banner (2000 mm x 500 mm)");
                        super.addPrice(5400);
                        break;
                    case GLOSS:
                        super.setDisplayName("Gloss Banner (2000 mm x 500 mm)");
                        super.addPrice(5300);
                        break;
                }
                break;
            case TREE_BY_ONE:
                switch (bannerMaterial) {
                    case SCRIM:
                        super.setDisplayName("Scrim Banner (3000 mm x 1000 mm)");
                        super.addPrice(6100);
                        break;
                    case MESH:
                        super.setDisplayName("Mesh Banner (3000 mm x 1000 mm)");
                        super.addPrice(6100);
                        break;
                    case GLOSS:
                        super.setDisplayName("Gloss Banner (3000 mm x 1000 mm)");
                        super.addPrice(6000);
                        break;
                }
                break;
        }
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

    public BannerSize getBannerSize() {
        return this.bannerSize;
    }

    public BannerMaterial getBannerMaterial() {
        return bannerMaterial;
    }

}
