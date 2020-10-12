package academy.pocu.comp2500.assignment2;

public class Product {
    private Size size;
    private String name;
    private Color color;
    private int price;
    private ShippingMethod shippingMethod;
    private int width;
    private int height;

    protected Product(Size size, Color color, ShippingMethod shippingMethod) {
        this.size = size;
        this.width = size.getWidth();
        this.height = size.getHeight();
        this.color = color;
        this.shippingMethod = shippingMethod;
    }

    protected void setSize(Size size) {
        this.size = size;
        this.width = size.getWidth();
        this.height = size.getHeight();
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

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String getName() {
        return name;
    }

    public Color getColorInstance() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public int getColor() {
        return color.getIntColor();
    }

    public int getPrice() {
        return price;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }
}