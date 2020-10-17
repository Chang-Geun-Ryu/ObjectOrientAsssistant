package academy.pocu.comp2500.assignment2;

public class PortraitBusinessCard extends BusinessCard {
    public PortraitBusinessCard(BusinessCardType type, BusinessCardColor paperColor, Side businessCardSides, ShippingMethod shippingMethod) {
        super(type, paperColor, Orientation.PORTRAIT, businessCardSides, shippingMethod);
    }
}
