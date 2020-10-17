package academy.pocu.comp2500.assignment2;

public class LandscapeBusinessCard extends BusinessCard {
    public LandscapeBusinessCard(BusinessCardType type, BusinessCardColor paperColor, Side businessCardSides, ShippingMethod shippingMethod) {
        super(type, paperColor, Orientation.LANDSCAPE, businessCardSides, shippingMethod);
    }
}
