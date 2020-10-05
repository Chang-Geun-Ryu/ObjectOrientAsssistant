package academy.pocu.comp2500.assignment2;

public class Product {
    private Size size;
    private String name;
    private Color color;
    private int price;
    private ShippingMethod shippingMethod;

    protected Product(Size size, Color color, ShippingMethod shippingMethod) {
        this.size = size;
        this.color = color;
        this.shippingMethod = shippingMethod;
    }

    public Size getSize() {
        return size;
    }

    protected void setSize(Size size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    protected void setColor(Color color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    protected void setPrice(int price) {
        this.price = price;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    protected void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}