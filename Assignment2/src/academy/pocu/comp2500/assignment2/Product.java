package academy.pocu.comp2500.assignment2;

public class Product {
    protected String type;
    protected int width;
    protected int height;
    protected Color color;
    protected int price;
    protected DeliveryMethod deliveryMethod;

    protected Product(String type, int width, int height, Color color, int price, DeliveryMethod deliveryMethod) {
        this.type = type;
        this.width = width;
        this.height = height;
        this.color = color;
        this.price = price;
        this.deliveryMethod = deliveryMethod;
    }

    public String getDisplayName() {
        boolean isOneSize = this.type.contains("Calendar") || this.type.contains("Card");
        return type + (isOneSize ? "" : " (" + width + " mm x " + height + " mm)");
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    protected void setHeight(int height) {
        this.height = height;
    }

    protected void setColor(Color color) {
        this.color = color;
    }

    protected void addPrice(int price) {
        this.price += price;
    }

    protected void setDisplayName(String type) {
        this.type = type;
    }
}
