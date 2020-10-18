package academy.pocu.comp2500.assignment2;

public class Banner extends ProductWithImage {
    private static final PriceBySize[] GLOSS_BANNER_PRICES = new PriceBySize[]{
            new PriceBySize(BannerSize.SMALL.getSize(), BannerPrice.GLOSS_SMALL.getPrice()),
            new PriceBySize(BannerSize.MIDIUM.getSize(), BannerPrice.GLOSS_MEDIUM.getPrice()),
            new PriceBySize(BannerSize.LARGE.getSize(), BannerPrice.GLOSS_LARGE.getPrice()),
            new PriceBySize(BannerSize.VERY_LARGE.getSize(), BannerPrice.GLOSS_VERY_LARGE.getPrice())
    };

    private static final PriceBySize[] SCRIM_BANNER_PRICES = new PriceBySize[]{
            new PriceBySize(BannerSize.SMALL.getSize(), BannerPrice.SCRIM_SMALL.getPrice()),
            new PriceBySize(BannerSize.MIDIUM.getSize(), BannerPrice.SCRIM_MEDIUM.getPrice()),
            new PriceBySize(BannerSize.LARGE.getSize(), BannerPrice.SCRIM_LARGE.getPrice()),
            new PriceBySize(BannerSize.VERY_LARGE.getSize(), BannerPrice.SCRIM_VERY_LARGE.getPrice())
    };

    private static final PriceBySize[] MESH_BANNER_PRICES = new PriceBySize[]{
            new PriceBySize(BannerSize.SMALL.getSize(), BannerPrice.MESH_SMALL.getPrice()),
            new PriceBySize(BannerSize.MIDIUM.getSize(), BannerPrice.MESH_MEDIUM.getPrice()),
            new PriceBySize(BannerSize.LARGE.getSize(), BannerPrice.MESH_LARGE.getPrice()),
            new PriceBySize(BannerSize.VERY_LARGE.getSize(), BannerPrice.MESH_VERY_LARGE.getPrice())
    };

    private static int getPriceFrom(PriceBySize[] priceTable, BannerSize size) {
        for (PriceBySize tuple : priceTable) {
            if (tuple.getSize() == size.getSize()) {
                return tuple.getPrice();
            }
        }

        return -1;
    }

    protected static int getPriceBy(BannerType type, BannerSize size) {
        if (type == BannerType.GLOSS_BANNER) {
            return getPriceFrom(GLOSS_BANNER_PRICES, size);
        } else if (type == BannerType.SCRIM_BANNER) {
            return getPriceFrom(SCRIM_BANNER_PRICES, size);
        } else if (type == BannerType.MESH_BANNER) {
            return getPriceFrom(MESH_BANNER_PRICES, size);
        } else {
            return -1;
        }
    }

    public Banner(BannerType type, Color color, BannerSize size, Orientation orientation, ShippingMethod shippingMethod) {
        super(type.getType(), color, size.getSize(), getPriceBy(type, size), orientation, shippingMethod);
    }
}
