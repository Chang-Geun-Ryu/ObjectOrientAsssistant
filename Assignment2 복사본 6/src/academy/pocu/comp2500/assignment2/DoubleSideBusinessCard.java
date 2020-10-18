package academy.pocu.comp2500.assignment2;

public class DoubleSideBusinessCard extends BusinessCard {
    public DoubleSideBusinessCard(BusinessCardType type, BusinessCardColor paperColor, Orientation orientation, ShippingMethod shippingMethod) {
        super(type, paperColor, orientation, Side.DOUBLE_SIDE, shippingMethod);
    }
}
