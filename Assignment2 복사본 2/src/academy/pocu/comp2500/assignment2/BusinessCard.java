package academy.pocu.comp2500.assignment2;

public class BusinessCard extends ApertureProduct {
    private final BusinessCardSides businessCardSides;
    private BusinessCardType businessCardType;
    private BusinessCardColor businessCardColor;

    public BusinessCard(BusinessCardType businessCardType, Orientation orientation,
                        BusinessCardColor businessCardColor, BusinessCardSides businessCardSides, Delivery delivery) {
        super(orientation, delivery);
        this.width = 90;
        this.height = 50;
        this.businessCardSides = businessCardSides;
        this.businessCardType = businessCardType;
        this.businessCardColor = businessCardColor;


        switch (businessCardType) {
            case LINEN: {
                super.name = "Linen Business Card";
                super.price = 110;
                break;
            }
            case LAID:
                super.name = "Laid Business Card";
                super.price = 120;
                break;
            case SMOOTH:
                super.name = "Smooth Business Card";
                super.price = 100;
                break;
        }

        switch (businessCardColor) {
            case GRAY: {
                super.r = 230;
                super.g = 230;
                super.b = 230;
                break;
            }
            case IVORY:
                super.r = 255;
                super.g = 255;
                super.b = 240;
                break;
            case WHITE: {
                super.r = 255;
                super.g = 255;
                super.b = 255;
                break;
            }
        }

        if (this.businessCardSides == BusinessCardSides.DOUBLE_SIDED) {
            super.price += 30;
        }
    }

    public BusinessCardSides getBusinessCardSides() {
        return businessCardSides;
    }

    public BusinessCardType getBusinessCardType() {
        return businessCardType;
    }

    public BusinessCardColor getBusinessCardColor() {
        return businessCardColor;
    }
}
