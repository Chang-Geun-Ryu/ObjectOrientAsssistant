package academy.pocu.comp2500.assignment2;

public enum StampSize {
    CM_4X3(40, 30, 2300),
    CM_5X2(50, 20, 2300),
    CM_7X4(70, 40, 2600);

    private int width;
    private int height;
    private int price;

    private StampSize(int width, int height, int price) {
        this.width = width;
        this.height = height;
        this.price = price;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getPrice() {
        return this.price;
    }
}
