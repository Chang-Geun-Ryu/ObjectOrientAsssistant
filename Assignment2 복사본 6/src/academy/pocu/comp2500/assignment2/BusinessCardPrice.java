package academy.pocu.comp2500.assignment2;

public enum BusinessCardPrice {
    LINEN_SINGLE_SIDE(110),
    LINEN_DOUBLE_SIDE(140),

    LAID_SINGLE_SIDE(120),
    LAID_DOUBLE_SIDE(150),

    SMOOTH_SINGLE_SIDE(100),
    SMOOTH_DOUBLE_SIDE(130);

    private final int price;

    BusinessCardPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
