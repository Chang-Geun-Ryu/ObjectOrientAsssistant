package academy.pocu.comp2500.assignment2;

public class SmoothBusinessCard extends BusinessCard {
    public SmoothBusinessCard(BusinessCardColor paperColor, Orientation orientation, Side businessCardSides, ShippingMethod shippingMethod) {
        super(BusinessCardType.SMOOTH_BUSINESS_CARD, paperColor, orientation, businessCardSides, shippingMethod);
    }
}
