package academy.pocu.comp2500.assignment2;

public enum StampPrice {
    SMALL(2300),
    MEDIUM(2300),
    LARGE(2600);

    private final int price;

    StampPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
