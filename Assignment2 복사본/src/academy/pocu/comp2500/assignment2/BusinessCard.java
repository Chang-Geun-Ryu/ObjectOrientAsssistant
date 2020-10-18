package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class BusinessCard extends ApertureProduct {
    private BusinessCardType type;
    private CardColor cardColor;
    private CardSide sides;
    private Orientation orientation;


    public BusinessCard(BusinessCardType type, CardSide sides, Orientation orientation, CardColor cardColor) {
        super(new Size(90, 50), new Color(0, 0, 0));
        this.type = type;
        this.sides = sides;
        this.orientation = orientation;
        this.cardColor = cardColor;

        if (cardColor == CardColor.GRAY) {
            this.setColor(new Color(0xE6, 0xE6, 0xE6));
        } else if (cardColor == CardColor.IVORY) {
            this.setColor(new Color(0xFF, 0xFF, 0xF0));
        } else if (cardColor == CardColor.WHITE) {
            this.setColor(new Color(0xFF, 0xFF, 0xFF));
        }

        if (type == BusinessCardType.LINEN) {
            this.setName("Linen Business Card");
            this.setPrice(110);
        } else if (type == BusinessCardType.LAID) {
            this.setName("Laid Business Card");
            this.setPrice(120);
        } else if (type == BusinessCardType.SMOOTH) {
            this.setName("Smooth Business Card");
            this.setPrice(100);
        }

        if (sides == CardSide.DOUBLE_SIDE) {
            this.setPrice(this.getPrice() + 30);
        }
    }

    public BusinessCardType getType() {
        return type;
    }

    public CardColor getCardColor() {
        return cardColor;
    }

    public CardSide getSides() {
        return sides;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
