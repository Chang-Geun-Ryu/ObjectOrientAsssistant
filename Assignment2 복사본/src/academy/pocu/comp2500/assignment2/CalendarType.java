package academy.pocu.comp2500.assignment2;

public enum CalendarType {
    WALL("Wall", 400, 400, 1000),
    DESK("Desk", 200, 150, 1000),
    MAGNET("Magnet", 100, 200, 1500);

    private String name;
    private int width;
    private int height;
    private int price;

    private CalendarType(String name, int width, int height, int price) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.price = price;
    }

    public String getName() {
        return this.name;
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
}
