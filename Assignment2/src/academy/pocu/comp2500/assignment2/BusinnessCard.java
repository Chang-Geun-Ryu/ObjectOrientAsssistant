package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class BusinnessCard extends ApertureProduct {

    private BusinessCardType businessCardType;
    private CardSides side;
//    public enum BusinessCardType {
//        LINEN_CARD, LAID_CARD, SMOOTH_CARD;
//    }

//    public enum CardSides {
//        SINGLESIDED_BUSINESS_CARD, DOUBLESIDED_BUSINESS_CARD;
//    }

//    public enum BusinessCardColor {
//        IVORY_CARD, WHITE_CARD, GRAY_CARD;
//    }

    public BusinnessCard(String productId, BusinessCardType businessCardType, CardSides cardSides, BusinessCardColor businessCardColor, Orientation orientation, ShippingMethod shippingMethod) {
        super(productId);
        super.shippingMethod = shippingMethod;
        double width = 90;
        double height = 50;
        this.businessCardType = businessCardType; // ~
        this.side = cardSides;
        // 세로 방향일 때, 가로 세로 변경
        if (orientation == Orientation.PORTRAIT) {
            double temp = width;
            width = height;
            height = temp;
        }

        super.size = new Size(width, height);

        switch (businessCardType) {
            case LINEN_CARD:
                super.price = 110;
                super.displayName = "Linen Business Card";
                break;
            case LAID_CARD:
                super.price = 120;
                super.displayName = "Laid Business Card";
                break;
            case SMOOTH_CARD:
                super.price = 100;
                super.displayName = "Smooth Business Card";
                break;
        }

        if (cardSides == CardSides.DOUBLESIDED_BUSINESS_CARD) {
            super.price += 30;
        }

        switch (businessCardColor) {
            case IVORY_CARD:
//                super.color = new Color(Integer.valueOf("FF"), Integer.valueOf("FF"), Integer.valueOf("F0"));
                super.color = new Color(0xFF, 0xFF, 0xF0);
                break;
            case WHITE_CARD:
//                super.color = new Color(Integer.valueOf("FF"), Integer.valueOf("FF"), Integer.valueOf("FF"));
                super.color = new Color(0xFF, 0xFF, 0xFF);
                break;
            case GRAY_CARD:
//                super.color = new Color(Integer.valueOf("E6"), Integer.valueOf("E6"), Integer.valueOf("E6"));
                super.color = new Color(0xE6, 0xE6, 0xE6);
                break;
        }
    }

    public CardSides getSide() {
        return this.side;
    }

    public BusinessCardType getBusinessCardType() {
        return businessCardType;
    }

}
