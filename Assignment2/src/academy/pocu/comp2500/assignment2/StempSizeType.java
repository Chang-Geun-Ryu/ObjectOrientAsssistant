package academy.pocu.comp2500.assignment2;

public enum StempSizeType {
    FOUR_BY_THREE(" (40 mm x 30 mm)", 40, 30, 2300),
    FIVE_BY_TWO(" (50 mm x 20 mm)", 50, 20, 2300),
    SEVEN_BY_FOUR(" (70 mm x 40 mm)", 70, 40, 2600);

    private String size;
    private int width;
    private int height;
    private int price;

    public String getSize() {
        return size;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPrice() {
        return price;
    }

    private StempSizeType(String size, int width, int height, int price){
        this.size = size;
        this.width = width;
        this.height = height;
        this.price = price;
    }
}