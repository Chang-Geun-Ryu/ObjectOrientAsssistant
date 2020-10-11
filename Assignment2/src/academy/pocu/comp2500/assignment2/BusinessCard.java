package academy.pocu.comp2500.assignment2;

public class BusinessCard extends ApertureProduct {
    private BusinessCardSides businessCardSides;
    private BusinessCardType type;

    public BusinessCard(BusinessCardType businessCardType, BusinessCardColor businessCardColor,
                        BusinessCardSides businessCardSides, Orientation orientation, DeliveryMethod deliveryMethod) {
        super(new Size(90, 50), getPrice(businessCardType, businessCardSides),
                getColor(businessCardColor), orientation, deliveryMethod);
        this.businessCardSides = businessCardSides;
        this.type = businessCardType;
    }

    private static int getPrice(BusinessCardType businessCardType, BusinessCardSides businessCardSides) {
        int price = 0;
        switch (businessCardType) {
            case LINEN:
                if (businessCardSides == BusinessCardSides.SINGLE) {
                    price = 110;
                } else {
                    price = 140;
                }
                break;

            case LAID:
                if (businessCardSides == BusinessCardSides.SINGLE) {
                    price = 120;
                } else {
                    price = 150;
                }
                break;

            case SMOOTH:
                if (businessCardSides == BusinessCardSides.SINGLE) {
                    price = 100;
                } else {
                    price = 130;
                }
                break;
        }
        return price;
    }

    private static Color getColor(BusinessCardColor businessCardColor) {
        Color color;
        switch (businessCardColor) {
            case GREY:
                color = new Color(0xE6, 0xE6, 0xE6);
                break;
            case IVORY:
                color = new Color(0xFF, 0xFF, 0xF0);
                break;
            case WHITE:
                color = new Color(0xFF, 0xFF, 0xFF);
                break;
            default:
                color = null;
                break;
        }
        return color;
    }

    /*static private String getDisplayName(BusinessCardType businessCardType) {
        String name = "";
        switch (businessCardType) {
            case LINEN:
                name = "Linen Business Card";
                break;
            case LAID:
                name = "Laid Business Card";
                break;
            case SMOOTH:
                name = "Smooth Business Card";
                break;
        }
        return name;
    }*/

    public BusinessCardSides getBusinessCardSides() {
        return businessCardSides;
    }

    public BusinessCardType getType() {
        return type;
    }
}
