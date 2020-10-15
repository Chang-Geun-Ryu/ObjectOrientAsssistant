package academy.pocu.comp2500.assignment2;

public enum BannerSize {
    ONE_HALF(" (1000 mm x 500 mm)", 1000, 500, 5000),
    ONE_ONE(" (1000 mm x 1000 mm)", 1000, 1000, 5200),
    TWO_HALF(" (2000 mm x 500 mm)", 2000, 500, 5300),
    THREE_ONE(" (3000 mm x 1000 mm)", 3000, 1000, 6000);

    private int width;
    private int height;
    private int price;
    private String size;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    private BannerSize(String size, int width, int height, int price) {
        this.width = width;
        this.height = height;
        this.price = price;
        this.size = size;
    }
}
