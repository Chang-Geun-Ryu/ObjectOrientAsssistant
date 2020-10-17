package academy.pocu.comp2500.assignment2;

public class BusinessCard extends ProductWithImage {
    private static final PriceBySide[] LINEN_BUSINESS_CARD_PRICES = new PriceBySide[]{
            new PriceBySide(Side.SINGLE_SIDE, BusinessCardPrice.LINEN_SINGLE_SIDE.getPrice()),
            new PriceBySide(Side.DOUBLE_SIDE, BusinessCardPrice.LINEN_DOUBLE_SIDE.getPrice()),
    };

    private static final PriceBySide[] LAID_BUSINESS_CARD_PRICES = new PriceBySide[]{
            new PriceBySide(Side.SINGLE_SIDE, BusinessCardPrice.LAID_SINGLE_SIDE.getPrice()),
            new PriceBySide(Side.DOUBLE_SIDE, BusinessCardPrice.LAID_DOUBLE_SIDE.getPrice()),
    };

    private static final PriceBySide[] SMOOTH_BUSINESS_CARD_PRICES = new PriceBySide[]{
            new PriceBySide(Side.SINGLE_SIDE, BusinessCardPrice.SMOOTH_SINGLE_SIDE.getPrice()),
            new PriceBySide(Side.DOUBLE_SIDE, BusinessCardPrice.SMOOTH_DOUBLE_SIDE.getPrice()),
    };

    private static int getPriceFrom(PriceBySide[] priceTable, Side side) {
        for (PriceBySide tuple : priceTable) {
            if (tuple.getSide() == side) {
                return tuple.getPrice();
            }
        }

        return -1;
    }

    private static int getPriceBy(BusinessCardType type, Side side) {
        if (type == BusinessCardType.LINEN_BUSINESS_CARD) {
            return getPriceFrom(LINEN_BUSINESS_CARD_PRICES, side);
        } else if (type == BusinessCardType.LAID_BUSINESS_CARD) {
            return getPriceFrom(LAID_BUSINESS_CARD_PRICES, side);
        } else if (type == BusinessCardType.SMOOTH_BUSINESS_CARD) {
            return getPriceFrom(SMOOTH_BUSINESS_CARD_PRICES, side);
        } else {
            return -1;
        }
    }

    private Side side;

    public BusinessCard(BusinessCardType type, BusinessCardColor color, Orientation orientation, Side businessCardSides, ShippingMethod shippingMethod) {
        super(type.getType(), color.getColor(), new Size(90, 50), getPriceBy(type, businessCardSides), orientation, shippingMethod);

        this.side = businessCardSides;
    }

    public Side getSide() {
        return side;
    }
}
