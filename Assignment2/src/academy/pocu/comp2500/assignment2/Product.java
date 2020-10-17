package academy.pocu.comp2500.assignment2;

public class Product {
    protected String displayName;
    protected Color color;
    protected int width;
    protected int height;
    protected int price;
    protected ShippingMethod shippingMethod;

    protected Product(String displayName, Color color, int width, int height, int price, ShippingMethod shippingMethod) {
        this.displayName = displayName;
        this.color = color;
        this.width = width;
        this.height = height;
        this.price = price;
        this.shippingMethod = shippingMethod;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Color getColor() {
        return color;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public int getPrice() {
        return price;
    }
}
