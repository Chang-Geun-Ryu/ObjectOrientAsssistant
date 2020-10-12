package academy.pocu.comp2500.assignment2;

public class BusinessCard extends CustomizingProduct {
    private PaperType paperType;
    private PaperColor paperColor;
    private CardSides cardSides;

    public BusinessCard(PaperType paperType, PaperColor paperColor, CardSides cardSides, Orientation orientation) {
        super.setWidth(90);
        super.setHeight(50);
        super.setOrientation(orientation);
        this.cardSides = cardSides;
        setPaperColor(paperColor);
        setPaperType(paperType);
    }

    private void calculatePrice() {
        int calculate = 0;
        switch (this.paperType) {
            case LINEN:
                calculate = 110;
                break;
            case LAID:
                calculate = 120;
                break;
            case SMOOTH:
                calculate = 100;
                break;
            default:
                assert (false) : "CardType is invalid!";
                break;
        }
        if (this.cardSides == CardSides.DOUBLE) {
            calculate += 30;
        }
        calculate += (5 * super.getApertures().size());
        super.setPrice(calculate);
    }

    public PaperType getPaperType() {
        return this.paperType;
    }

    public PaperColor getPaperColor() {
        return this.paperColor;
    }

    public CardSides getCardSides() {
        return this.cardSides;
    }

    private void setPaperType(PaperType paperType) {
        super.setName(String.format("%s Business Card", paperType.getName()));
        this.paperType = paperType;
        calculatePrice();
    }

    private void setPaperColor(PaperColor paperColor) {
        this.paperColor = paperColor;
        switch (paperColor) {
            case GRAY:
                super.setRGB(new RGB(0xE6, 0xE6, 0xE6));
                break;
            case IVORY:
                super.setRGB(new RGB(0xFF, 0xFF, 0xF0));
                break;
            case WHITE:
                super.setRGB(new RGB(0xFF, 0xFF, 0xFF));
                break;
            default:
                assert (false) : "CardColor is invalid!";
                break;
        }
    }

    private void setCardSides(CardSides cardSides) {
        this.cardSides = cardSides;
        calculatePrice();
    }
}
