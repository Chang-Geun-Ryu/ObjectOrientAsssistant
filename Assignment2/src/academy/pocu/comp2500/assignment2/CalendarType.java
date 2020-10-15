package academy.pocu.comp2500.assignment2;

public enum CalendarType {
    WALL("Wall Calendar", "400 mm x 400 mm", 400, 400, 1000),
    DESK("Desk Calendar", "200 mm x 150 mm",  200, 150, 1000),
    MAGNET("Magnet Calendar", "100 mm x 200 mm",  100, 200, 1500);

    final private String name;
    final private String size;
    final private int width;
    final private int height;
    final private int price;

    public String getName() {
        return name;
    }
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

    private CalendarType(String name, String size, int width, int height, int price){
        this.name = name;
        this.size = size;
        this.width = width;
        this.height = height;
        this.price = price;
    }
}
