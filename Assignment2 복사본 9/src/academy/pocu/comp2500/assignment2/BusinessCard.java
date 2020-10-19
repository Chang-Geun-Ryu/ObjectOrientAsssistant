package academy.pocu.comp2500.assignment2;

public class BusinessCard extends OrientationProduct {
    private CardSides cardSides;
    private BusinessCardMaterial paperMaterial;
    private BusinessCardColor paperColor;

    public BusinessCardMaterial getPaperMaterial() {
        return paperMaterial;
    }

    public CardSides getCardSides() {
        return cardSides;
    }

//    public BusinessCardColor getPaperColor() {
//        return paperColor;
//    }

    public BusinessCard(Orientation orientation, BusinessCardColor paperColor, BusinessCardMaterial paperMaterial, CardSides cardSides) {
        this.cardSides = cardSides;
        this.paperMaterial = paperMaterial;
        this.orientation = orientation;
        this.paperColor = paperColor;
        size = new Size(90, 50);

        switch (paperColor) {
            case GREY:
                //color = 0xe6e6e6;
                color = new RGB(0xe6, 0xe6, 0xe6);
                break;
            case IVORY:
                //color = 0xfffff0;
                color = new RGB(0xff, 0xff, 0xf0);
                break;
            case WHITE:
                //color = 0xffffff;
                color = new RGB(0xff, 0xff, 0xff);
                break;
        }

        switch (paperMaterial) {
            case LINEN:
                switch (cardSides) {
                    case SINGLESIDEDCARD:
                        price = 110;
                        break;
                    case DOUBLESIDEDCARD:
                        price = 140;
                        break;
                }
                displayName = "Linen Business Card";
                break;
            case LAID:
                switch (cardSides) {
                    case SINGLESIDEDCARD:
                        price = 120;
                        break;
                    case DOUBLESIDEDCARD:
                        price = 150;
                        break;
                }
                displayName = "Laid Business Card";
                break;
            case SMOOTH:
                switch (cardSides) {
                    case SINGLESIDEDCARD:
                        price = 100;
                        break;
                    case DOUBLESIDEDCARD:
                        price = 130;
                        break;
                }
                displayName = "Smooth Business Card";
                break;
        }

    }

}
