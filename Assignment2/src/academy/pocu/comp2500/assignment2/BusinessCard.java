package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class BusinessCard extends ApertureProduct {

    private EBusinessCardType businessCardType;
    private EBusinessCardColor businessCardColor;
    private ESides businessCardSides;


    public BusinessCard(EBusinessCardType businessCardType, EBusinessCardColor businessCardColor, EOrientation orientation, ESides businessCardSides, EShippingMethod shippingMethod) {
        super(orientation, shippingMethod);
        imageApertures = new ArrayList<>();
        textApertures = new ArrayList<>();
        this.businessCardType = businessCardType;
        switch (businessCardColor) {
            case GRAY:
                color = new Color(0xe6, 0xe6, 0xe6);
                break;
            case IVORY:
                color = new Color(0xff, 0xff, 0xf0);
                break;
            case WHITE:
                color = new Color(0xff, 0xff, 0xff);
                break;
            default:
                assert false;
        }
        this.businessCardSides = businessCardSides;
        if (orientation == EOrientation.PORTRAIT) {
            demension = new Demension(50, 90);
        } else {
            demension = new Demension(50, 90);
        }
        switch (businessCardType) {
            case LINEN:
                price = 110;
                break;
            case LAID:
                price = 120;
                break;
            case SMOOTH:
                price = 100;
                break;
            default:
                assert false;
        }
        if (businessCardSides == ESides.DOUBLE) {
            price += 30;
        }
    }

    public EBusinessCardType getBusinessCardType() {
        return businessCardType;
    }

    public EBusinessCardColor getBusinessCardColor() {
        return businessCardColor;
    }

    public ESides getBusinessCardSides() {
        return businessCardSides;
    }
}
