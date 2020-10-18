package academy.pocu.comp2500.assignment2;

public class Product {
    private final String type;
    private final Color color;
    private final Size size;
    private int price;
    private ShippingMethod shippingMethod;

    public Product(String type, Color color, Size size, int price, ShippingMethod shippingMethod) {
        this.type = type;
        this.color = color;
        this.size = size;
        this.price = price;
        this.shippingMethod = shippingMethod;
    }

    public String getName() {
        return type;
    }

    public int getRedValue() {
        return color.getRed();
    }

    public int getGreenValue() {
        return color.getGreen();
    }

    public int getBlueValue() {
        return color.getBlue();
    }

    public int getWidth() {
        return size.getWidth();
    }

    public int getHeight() {
        return size.getHeight();
    }

    public int getPrice() {
        return price;
    }

    protected void setPrice(int price) {
        this.price = price;
    }

    public ShippingMethod getshippingMethod() {
        return shippingMethod;
    }

    public void setshippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
