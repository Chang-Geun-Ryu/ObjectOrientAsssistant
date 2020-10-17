package academy.pocu.comp2500.assignment2;

public class LaidBusinessCard extends BusinessCard {
    public LaidBusinessCard(BusinessCardColor paperColor, Orientation orientation, Side businessCardSides, ShippingMethod shippingMethod) {
        super(BusinessCardType.LAID_BUSINESS_CARD, paperColor, orientation, businessCardSides, shippingMethod);
    }
}
