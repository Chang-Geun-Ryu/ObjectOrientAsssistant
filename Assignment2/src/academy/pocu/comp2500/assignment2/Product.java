package academy.pocu.comp2500.assignment2;

import java.util.HashMap;

public class Product {
    protected String name;
    protected int price;
    protected int length;
    protected int height;
    protected int red;
    protected int green;
    protected int blue;
    protected ShippingMethod shippingMethod;

    protected Product(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getLength() {
        return this.length;
    }

    public int getHeight() {
        return this.height;
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

    public HashMap<Character, Integer> getColor() {
        HashMap<Character, Integer> color = new HashMap<>();
        color.put('r', this.red);
        color.put('g', this.green);
        color.put('b', this.blue);

        return color;
    }

    public ShippingMethod getShippingMethod() {
        return this.shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
