package academy.pocu.comp2500.assignment2;

public enum BusinessCardSide {
    SINGLE("단면", 0),
    DOUBLE("양면", 30);

    private int addPrice;
    private String side;

    public int getAddPrice() {
        return addPrice;
    }

    public String getSide() {
        return side;
    }

    private BusinessCardSide(String side, int addPrice) {
        this.addPrice = addPrice;
        this.side = side;
    }
}
