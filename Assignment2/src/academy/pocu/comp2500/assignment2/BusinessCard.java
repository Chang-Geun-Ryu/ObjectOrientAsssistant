package academy.pocu.comp2500.assignment2;

public class BusinessCard extends ApertureProduct {
    private BusinessCardType type;
    private BusinessCardSides sides;

    public BusinessCard(BusinessCardType type, BusinessCardColor businessCardColor, BusinessCardSides sides, Orientation orientation, ShippingMethod shippingMethod) {
        super("Business Card", null, 90, 50, 0, shippingMethod, orientation);

        this.type = type;
        this.sides = sides;

        switch (businessCardColor) {
            case GRAY:
                super.color = new Color(0xE6, 0xE6, 0xE6);
                break;
            case IVORY:
                super.color = new Color(0xFF, 0xFF, 0xF0);
                break;
            case WHITE:
                super.color = new Color(0xFF, 0xFF, 0xFF);
                break;
        }

        switch (sides) {
            case SINGLE:
                super.price = 110;
                break;
            case DOUBLE:
                super.price = 140;
                break;
        }

        switch (type) {
            case LINEN:
                super.displayName = "Linen Business Card";
                break;
            case LAID:
                super.displayName = "Laid Business Card";
                super.price += 10;
                break;
            case SMOOTH:
                super.displayName = "Smooth Business Card";
                super.price -= 10;
                break;
        }
    }

    public BusinessCardType getBusinessCardType() {
        return type;
    }

    public BusinessCardSides getBusinessCardSides() {
        return sides;
    }
}
