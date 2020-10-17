package academy.pocu.comp2500.assignment2;

public class Product {
    protected String name;
    protected int width;
    protected int height;
    protected int price;
    protected short r;
    protected short g;
    protected short b;
    protected Delivery delivery;

    protected Product(Delivery delivery) {
        this.delivery = delivery;
    }

    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPrice() {
        return price;
    }

    public short getR() {
        return r;
    }

    public short getG() {
        return g;
    }

    public short getB() {
        return b;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
