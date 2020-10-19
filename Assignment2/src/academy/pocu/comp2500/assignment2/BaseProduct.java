package academy.pocu.comp2500.assignment2;


public class BaseProduct {

    private Color color;
    private ShippingMethod shippingMethod;
    protected int price;
    private Size size;
    protected String displayName;

    protected BaseProduct(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public int getPrice() {
        return price;
    }

    protected void setPrice(int price) {
        this.price = price;
    }

    protected void addPrice(int price) {
        this.price += price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }



    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public Size getSize() {
        return this.size;
    }

    protected void setSize(Size size) {
        this.size = size;
    }

    protected void setDisplayName(String name) {
        this.displayName = name;
    }

    public String getDisplayName() {
        return this.displayName;
    }
    //    public void setWidth(int width) {
//        if (this.size == null) {
//            this.size = new Size(width, 0);
//            return;
//        }
//        this.size.setWidth(width);
//    }
//
//    public void setHeight(int height) {
//        if (this.size == null) {
//            this.size = new Size(0, height);
//        }
//        this.size.setHeight(height);
//    }
}
