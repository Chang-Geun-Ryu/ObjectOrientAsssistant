package academy.pocu.comp2500.assignment2;

public class Banner extends ApertureProduct {
    private BannerMaterial bannerMaterial;
    private BannerSize bannerSize;
    private Orientation orientation;

    public Banner(BannerMaterial bannerMaterial, BannerSize bannerSize, Color color, Orientation orientation) {
        super(new Size(), color);
        this.bannerMaterial = bannerMaterial;
        this.orientation = orientation;
        this.bannerSize = bannerSize;

        if (bannerSize == BannerSize.SIZE_1_05) {
            this.setSize(new Size(1000, 500));
        } else if (bannerSize == BannerSize.SIZE_1_1) {
            this.setSize(new Size(1000, 1000));
            this.setPrice(200);
        } else if (bannerSize == BannerSize.SIZE_2_05) {
            this.setSize(new Size(2000, 500));
            this.setPrice(300);
        } else if (bannerSize == BannerSize.SIZE_3_1) {
            this.setSize(new Size(3000, 1000));
            this.setPrice(1000);
        }

        if (bannerMaterial == BannerMaterial.GLOSS) {
            this.setName(String.format("Gloss Banner (%d mm x %d mm)", this.getSize().getWidth(), this.getSize().getHeight()));
            this.setPrice(this.getPrice() + 5000);
        } else if (bannerMaterial == BannerMaterial.SCRIM || bannerMaterial == BannerMaterial.MESH) {
            if (bannerMaterial == BannerMaterial.SCRIM) {
                this.setName(String.format("Scrim Banner (%d mm x %d mm)", this.getSize().getWidth(), this.getSize().getHeight()));
            } else {
                this.setName(String.format("Mesh Banner (%d mm x %d mm)", this.getSize().getWidth(), this.getSize().getHeight()));
            }
            this.setPrice(this.getPrice() + 5100);
        }
    }

    public BannerMaterial getBannerMaterial() {
        return bannerMaterial;
    }

    public BannerSize getBannerSize() {
        return bannerSize;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}