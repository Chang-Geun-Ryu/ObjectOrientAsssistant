package academy.pocu.comp2500.assignment2;

// 상품 부모 클래스
public class Product {
    protected int price;
//    protected String productId;
    protected Size size;
    protected Color color;
    protected String displayName;
    protected ShippingMethod shippingMethod;

//    public enum ShippingMethod {
//        PICKUP, SHIP;
//    }

    protected Product() {
//        this.productId = productId;
        shippingMethod = ShippingMethod.PICKUP;
    }

    public int getPrice() {
        return price;
    }

//    public String getProductId() {
//        return productId;
//    }

    public Size getSize() {
        return size;
    }

    public int getWidth() {
        return size.getWidth();
    }

    public int getHeight() {
        return size.getHeight();
    }

    public Color getColor() {
        return color;
    }

    public String getDisplayName() {
        return displayName;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

}
