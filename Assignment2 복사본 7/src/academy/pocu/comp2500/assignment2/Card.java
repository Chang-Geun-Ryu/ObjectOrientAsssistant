package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Card extends ApertureProduct {

    private PaperType paperType;
    private PaperColor paperColor;
    private CardSides cardSides;

    protected Card(PaperType paperType, PaperColor paperColor, Orientation orientation, CardSides cardSides, DeliveryMethod deliveryMethod) {
        super("Card", 90, 50, null, 100, deliveryMethod, orientation);
        setPaperType(paperType);
        setPaperColor(paperColor);
        setCardSides(cardSides);
    }

    private void setPaperType(PaperType paperType) {
        this.paperType = paperType;
        if (this.paperType == PaperType.LINEN) {
            setDisplayName("Linen Business Card");
            addPrice(10);
        } else if (this.paperType == PaperType.LAID) {
            setDisplayName("Laid Business Card");
            addPrice(20);
        } else if (this.paperType == PaperType.SMOOTH) {
            setDisplayName("Smooth Business Card");
        }
    }

    private void setCardSides(CardSides cardSides) {
        this.cardSides = cardSides;
        if (this.cardSides == CardSides.DOUBLE) {
            addPrice(30);
        }
    }

    private void setPaperColor(PaperColor paperColor) {
        this.paperColor = paperColor;
        if (this.paperColor == PaperColor.GRAY) {
            setColor("GRAY");
        } else if (this.paperColor == PaperColor.WHITE) {
            setColor("WHITE");
        } else if (this.paperColor == PaperColor.IVORY) {
            setColor("IVORY");
        }
    }

    public CardSides getCardSides() {
        return cardSides;
    }

    public PaperColor getPaperColor() {
        return paperColor;
    }

    public PaperType getPaperType() {
        return paperType;
    }

}
