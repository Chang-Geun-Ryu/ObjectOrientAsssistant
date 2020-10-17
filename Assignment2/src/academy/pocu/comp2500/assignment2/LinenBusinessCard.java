package academy.pocu.comp2500.assignment2;

public class LinenBusinessCard extends BusinessCard {
    public LinenBusinessCard(BusinessCardColor paperColor, Orientation orientation, Side businessCardSides, ShippingMethod shippingMethod) {
        super(BusinessCardType.LINEN_BUSINESS_CARD, paperColor, orientation, businessCardSides, shippingMethod);
    }
}
