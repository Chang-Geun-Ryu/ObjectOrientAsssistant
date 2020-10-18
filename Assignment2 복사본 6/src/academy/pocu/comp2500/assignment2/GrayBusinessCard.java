package academy.pocu.comp2500.assignment2;

public class GrayBusinessCard extends BusinessCard {
    public GrayBusinessCard(BusinessCardType type, Orientation orientation, Side businessCardSides, ShippingMethod shippingMethod) {
        super(type, BusinessCardColor.GRAY, orientation, businessCardSides, shippingMethod);
    }
}
