package academy.pocu.comp2500.assignment2;

public class BusinessCard extends Option {
    protected Type type;
    protected BusinessCardColor color;
    protected BusinessCardSide side;

    public BusinessCard(Type type, BusinessCardSide sides, OrientationType orientation, BusinessCardColor color, ShippingOptionsType deliveryMethod) {
        super(orientation);
        this.side = sides;
        this.type = type;
        this.color = color;
        setName(type.getNameCard());
        setPrice(type.getPrice() + sides.getAddPrice());
        setDeliveryMethod(deliveryMethod);
        setWidth(type.getWidth());
        setHeight(type.getHeight());

//        setColor(color.getColor());
    }

//    public BusinessCardSide getSide() {
//        return this.side;
//    }

    public Type getType() {
        return type;
    }

    public BusinessCardSide getSide() {
        return this.side;
    }

    public BusinessCardColor getCardColor() {
        return this.color;
    }
    protected void setSide(BusinessCardSide side) {
        this.side = side;
    }
//    public BusinessCardSide getSide() {
//        return this.side;
//    }

//    public Type getType() {
//        return this.type;
//    }

//    public BusinessCardColor getColor() {
//        return this.color;
//    }

//    public int getWidth() {
//        return 90;
//    }
//
//    public int getHeight() {
//        return 50;
//    }

//    protected void setType(BusinessCardType type) {
//        this.type = type;
//    }
//
//    protected void setColor(BusinessCardColor color) {
//        this.color = color;
//    }

}