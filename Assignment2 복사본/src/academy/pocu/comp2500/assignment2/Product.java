package academy.pocu.comp2500.assignment2;

public class Product {
    private String name;
    private int price;
    private int width;
    private int height;
    private RGB rgb;
    private ShippingMethod shippingMethod;

    protected Product() {
        this.shippingMethod = ShippingMethod.PICKUP;
    }

    protected void setName(String name) {
        this.name = name;
    } //

    protected void setWidth(int width) {
        this.width = width;
    } //

    protected void setHeight(int height) {
        this.height = height;
    } //

    protected void setPrice(int price) {
        this.price = price;
    } //

    protected void setRGB(RGB rgb) {
        this.rgb = rgb;
    } //

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getName() {
        return name;
    } //

    public int getPrice() {
        return this.price;
    } //

    public int getColor() {
        return this.rgb.getIntRGB();
    } //

    public RGB getRgb() {
        return this.rgb;
    } //

    public int getWidth() {
        return this.width;
    } //

    public int getHeight() {
        return this.height;
    }

    public ShippingMethod getShippingMethod() {
        return this.shippingMethod;
    }
}
