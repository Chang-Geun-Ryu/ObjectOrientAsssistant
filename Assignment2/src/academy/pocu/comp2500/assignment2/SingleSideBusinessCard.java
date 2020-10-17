package academy.pocu.comp2500.assignment2;

public class SingleSideBusinessCard extends BusinessCard {
    public SingleSideBusinessCard(BusinessCardType type, BusinessCardColor paperColor, Orientation orientation, ShippingMethod shippingMethod) {
        super(type, paperColor, orientation, Side.SINGLE_SIDE, shippingMethod);
    }
}
