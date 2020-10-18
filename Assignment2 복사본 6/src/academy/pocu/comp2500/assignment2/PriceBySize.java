package academy.pocu.comp2500.assignment2;

public class PriceBySize {
    private final Size size;
    private final int price;

    public PriceBySize(Size size, int price) {
        this.size = size;
        this.price = price;
    }

    public Size getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }
}
