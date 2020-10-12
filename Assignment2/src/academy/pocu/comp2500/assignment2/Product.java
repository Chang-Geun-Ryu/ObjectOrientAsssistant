package academy.pocu.comp2500.assignment2;

public class Product {
    protected Size size;
    protected int price;
    private Color color;
    private DeliveryMethod deliveryMethod;

    public Product(Size size, int price, Color color, DeliveryMethod deliveryMethod) {
        this.size = size;
        this.price = price;
        this.color = color;
        this.deliveryMethod = deliveryMethod;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Color getColor() {
        //System.out.printf("r = %02X , g = %02X b = %02X\n", color.getR(),color.getG(),color.getB());
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public boolean isEquals(Product product) {
        return this.size.isEquals(product.size) && this.color.isEquals(product.color) && this.price == product.price;
    }
}
