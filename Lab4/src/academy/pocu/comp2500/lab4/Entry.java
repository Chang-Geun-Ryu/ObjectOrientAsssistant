package academy.pocu.comp2500.lab4;

import java.time.OffsetDateTime;

public class Entry {
    private int usingOrder;
    private int createOrder;
    private String value;


    public Entry(String value) {
        this.value = value;
        this.usingOrder = 0;
        this.createOrder = 0;
    }

    public int getCreateOrder() {
        return this.createOrder;
    }

    public void setCreateOrder(int order) {
        this.createOrder = order;
    }

    public int upShiftCreateOrder() {
        return ++this.createOrder;
    }

    public int downShiftCreateOrder() {
        return --this.createOrder;
    }

    public int getUsingOrder() {
        return this.usingOrder;
    }

    public void setZeroUsingOrder() {
        this.usingOrder = 0;
    }

    public void updateOrder() {
        this.usingOrder++;
    }

    public String getValue() {
        this.usingOrder = 0;
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
        this.usingOrder = 0;
    }
}