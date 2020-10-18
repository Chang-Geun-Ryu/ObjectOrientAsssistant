package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Product {
    enum ShippingMethod {
        PICKUP,
        SHIP
    }

    protected int red;
    protected int green;
    protected int blue;
    protected int height;
    protected int width;
    protected int price;
    private ShippingMethod shippingMethod;

    public Product(int red, int green, int blue, int width, int height, int price, ShippingMethod shippingMethod) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.height = height;
        this.width = width;
        this.price = price;
        this.shippingMethod = shippingMethod;
    }

    public int getRed() {
        return this.red;
    }

    public int getGreen() {
        return this.green;
    }

    public int getBlue() {
        return this.blue;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public ShippingMethod getShippingMethod() {
        return this.shippingMethod;
    }

    public int getPrice() {
        return this.price;
    }

    public void changeShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
