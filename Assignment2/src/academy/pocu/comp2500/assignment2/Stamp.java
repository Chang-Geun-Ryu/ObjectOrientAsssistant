package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private static final PriceBySize[] STAMP_PRICES = new PriceBySize[]{
            new PriceBySize(StampSize.SMALL.getSize(), StampPrice.SMALL.getPrice()),
            new PriceBySize(StampSize.MIDIUM.getSize(), StampPrice.MEDIUM.getPrice()),
            new PriceBySize(StampSize.LARGE.getSize(), StampPrice.LARGE.getPrice())
    };

    private static int getPriceBy(StampSize size) {
        for (PriceBySize tuple : STAMP_PRICES) {
            if (tuple.getSize() == size.getSize()) {
                return tuple.getPrice();
            }
        }

        return -1;
    }

    private final String text;

    public Stamp(Color color, StampSize size, String text, ShippingMethod shippingMethod) {
        super("Stamp", color, size.getSize(), getPriceBy(size), shippingMethod);

        this.text = text;
    }

    public String getText() {
        return text;
    }
}