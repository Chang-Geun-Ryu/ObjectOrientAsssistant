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

    public void setSize(Size size) {
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    protected Size getSize() {
        return size;
    }

    public int getWidth() {
        return size.getWidth();
    }

    public int getHeight() {
        return size.getHeight();
    }

    public String getName() {
        return name;
    }

//    public Color getColorIns() {
//        return color;
//    }

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