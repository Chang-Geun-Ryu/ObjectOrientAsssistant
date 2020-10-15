package academy.pocu.comp2500.assignment2;

public class Product {
    private String name;
    private int price;
    private ShippingOptionsType deliveryMethod;
    protected int width;
    protected int height;
//    private int color;

    protected Product() {
        this.name = "";
        this.price = 0;
        this.deliveryMethod = ShippingOptionsType.PICKUP;
        this.width = 0;
        this.height = 0;
    }

//    protected void setColor(int color) {
//        this.color = color;
//    }

    protected void setWidth(int width) {
        this.width = width;
    }

    protected  void setHeight(int height) {
        this.height = height;
    }

//    public int getColor() {
//        return this.color;
//    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;// + (this.texts.size() + this.imagePaths.size()) * 5;
    }

    public ShippingOptionsType getDeliveryMethod() {
        return this.deliveryMethod;
    }

    protected void setPrice(int price) {
        this.price = price;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public void setDeliveryMethod(ShippingOptionsType deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
}
