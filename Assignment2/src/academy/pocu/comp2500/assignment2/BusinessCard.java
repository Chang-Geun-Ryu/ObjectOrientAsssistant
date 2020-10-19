package academy.pocu.comp2500.assignment2;

public class BusinessCard extends CustomizableProduct {

    private CardSides cardSides;
    private PaperMaterial paperMaterial;
    private CardColor cardColor;

    public BusinessCard(Orientation cardOrientation, ShippingMethod shippingMethod, CardColor cardColor, CardSides cardSides, PaperMaterial paperMaterial) {
        super(cardOrientation, shippingMethod);

        Size size = new Size(90, 50);
        super.setSize(size);

        Color color;
        this.cardColor = cardColor;
        switch (cardColor) {
            case GREY:
                color = new Color(0xE6, 0xE6, 0xE6);
                super.setColor(color);
                break;
            case IVORY:
                color = new Color(0xFF, 0xFF, 0xF0);
                super.setColor(color);
                break;
            case WHITE:
                color = new Color(0xFF, 0xFF, 0xFF);
                super.setColor(color);
                break;
        }

        this.paperMaterial = paperMaterial;
        this.cardSides = cardSides;
        switch (paperMaterial) {
            case LINEN:
                super.setDisplayName("Linen Business Card");
                switch (cardSides) {
                    case SINGLE_SIDED_CARD:
                        super.setPrice(110);
                        break;
                    case DOUBLE_SIDED_CARD:
                        super.setPrice(140);
                        break;
                }
                break;
            case LAID:
                super.setDisplayName("Laid Business Card");
                switch (cardSides) {
                    case SINGLE_SIDED_CARD:
                        super.setPrice(120);
                        break;
                    case DOUBLE_SIDED_CARD:
                        super.setPrice(150);
                        break;
                }
                break;
            case SMOOTH:
                super.setDisplayName("Smooth Business Card");
                switch (cardSides) {
                    case SINGLE_SIDED_CARD:
                        super.setPrice(100);
                        break;
                    case DOUBLE_SIDED_CARD:
                        super.setPrice(130);
                        break;
                }
                break;
        }
    }

    public CardSides getCardSides() {
        return this.cardSides;
    }

    public CardColor getCardColor() {
        return this.cardColor;
    }

    public PaperMaterial getPaperMaterial() {
        return this.paperMaterial;
    }
}
