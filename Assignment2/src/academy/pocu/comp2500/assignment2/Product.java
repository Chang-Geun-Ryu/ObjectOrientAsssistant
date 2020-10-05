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

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    protected void setSize(Size size) {
        this.size = size;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setColor(Color color) {
        this.color = color;
    }

    protected void setPrice(int price) {
        this.price = price;
    }
}