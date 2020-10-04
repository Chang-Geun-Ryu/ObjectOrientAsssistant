package academy.pocu.comp2500.assignment2;

public enum Type {
    LINEN("Linen Business Card", "Gloss", 90, 50, 110, 0),
    LAID("Laid Business Card", "Scrim", 90, 50,  120, 100),
    SMOOTH("Smooth Business Card", "Mesh", 90, 50, 100, 100);

    final private String nameCard;
    final private String nameBanner;

    final private int width;
    final private int height;
    final private int price;
    final private int addPrice;


    public String getNameCard() {
        return nameCard;
    }
    public String getNameBanner() {
        return nameBanner;
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
    public int getAddPrice() {
        return addPrice;
    }


    private Type(String nameCard, String nameBanner, int width, int height, int price, int addPrice){
        this.nameCard = nameCard;
        this.nameBanner = nameBanner;
        this.width = width;
        this.height = height;
        this.price = price;
        this.addPrice = addPrice;
    }
}
