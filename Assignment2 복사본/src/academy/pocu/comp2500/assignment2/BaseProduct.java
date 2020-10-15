package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class BaseProduct {
    protected EShippingMethod shippingMethod;
    protected Demension demension;
    protected Color color;
    protected int price;

    protected BaseProduct(EShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    //setter,getter
    //setter
    public void setShippingMethod(EShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    //getter
    public EShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public Demension getDemension() {
        return demension;
    }

    public int getPrice() {
        return price;
    }

    public Color getColor() {
        return color;
    }


}
