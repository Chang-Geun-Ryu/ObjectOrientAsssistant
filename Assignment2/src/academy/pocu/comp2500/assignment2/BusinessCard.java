package academy.pocu.comp2500.assignment2;

public class BusinessCard extends ProductWithApertures {
    enum BusinessCardType {
        LINEN,
        LAID,
        SMOOTH
    }

    enum BusinessCardColor {
        GREY,
        IVORY,
        WHITE
    }

    private BusinessCardType businessCardType;
    private int sides;


    public BusinessCard(BusinessCardColor businessCardColor, BusinessCardType businessCardType, int sides, Orientation orientation, ShippingMethod shippingMethod) {
        super(getRed(businessCardColor), getGreen(businessCardColor), getBlue(businessCardColor), 9, 5, getPrice(businessCardType, sides), orientation, shippingMethod);

        this.businessCardType = businessCardType;
        this.sides = sides;
    }

    private static int getRed(BusinessCardColor businessCardColor) {
        if (businessCardColor == BusinessCardColor.GREY) {
            return 230;
        } else {
            return 255;
        }
    }

    private static int getGreen(BusinessCardColor businessCardColor) {
        if (businessCardColor == BusinessCardColor.GREY) {
            return 230;
        } else {
            return 255;
        }
    }

    private static int getBlue(BusinessCardColor businessCardColor) {
        if (businessCardColor == BusinessCardColor.GREY) {
            return 230;
        } else if (businessCardColor == BusinessCardColor.IVORY) {
            return 240;
        } else {
            return 255;
        }
    }

    private static int getPrice(BusinessCardType businessCardType, int sides) {
        if (businessCardType == BusinessCardType.LINEN) {
            if (sides == 1) {
                return 110;
            } else {
                return 140;
            }
        } else if (businessCardType == BusinessCardType.LAID) {
            if (sides == 1) {
                return 120;
            } else {
                return 150;
            }
        } else {
            if (sides == 1) {
                return 100;
            } else {
                return 130;
            }
        }
    }

    public BusinessCardType getBusinessCardType() {
        return businessCardType;
    }

    public int getSides() {
        return sides;
    }
}
