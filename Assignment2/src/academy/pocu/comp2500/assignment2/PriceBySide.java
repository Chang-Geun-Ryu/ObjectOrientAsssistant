package academy.pocu.comp2500.assignment2;

public class PriceBySide {
    private final Side side;
    private final int price;

    public PriceBySide(Side side, int price) {
        this.side = side;
        this.price = price;
    }

    public Side getSide() {
        return side;
    }

    public int getPrice() {
        return price;
    }
}
