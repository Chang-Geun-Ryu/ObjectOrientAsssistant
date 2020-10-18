package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Card extends Product {
//    private ArrayList<TextAperture> textApertures = new ArrayList<>();
//    private ArrayList<ImageAperture> imageApertures = new ArrayList<>();
    private ArrayList<Aperture> apertures = new ArrayList<>();
    private Orientation orientation;
    private PaperType paperType;
    private PaperColor paperColor;
    private CardSides cardSides;

    protected Card(PaperType paperType, PaperColor paperColor, Orientation orientation, CardSides cardSides, DeliveryMethod deliveryMethod) {
        super("Card", 90, 50, null, 100, deliveryMethod);
        this.orientation = orientation;
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
            setColor(new Color("GRAY"));
        } else if (this.paperColor == PaperColor.WHITE) {
            setColor(new Color("WHITE"));
        } else if (this.paperColor == PaperColor.IVORY) {
            setColor(new Color("IVORY"));
        }
    }

    public boolean addAperture(Aperture aperture) {
        if (isInAperture(aperture)) {
            this.apertures.add(aperture);
            addPrice(5);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Aperture> getApertures() {
        return  apertures;
    }

//    public boolean addTextAperture(TextAperture textAperture) {
//        if (isInAperture(textAperture)) {
//            this.textApertures.add(textAperture);
//            addPrice(5);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public boolean addImageAperture(ImageAperture imageAperture) {
//        if (isInAperture(imageAperture)) {
//            this.imageApertures.add(imageAperture);
//            addPrice(5);
//            return true;
//        } else {
//            return false;
//        }
//    }

//    public ArrayList<TextAperture> getTextApertures() {
//        return textApertures;
//    }
//
//    public ArrayList<ImageAperture> getImageApertures() {
//        return imageApertures;
//    }

    public Orientation getOrientation() {
        return orientation;
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

    private boolean isInAperture(Aperture aperture) {
        return (0 <= aperture.getX() && aperture.getX() + aperture.getWidth() <= this.getWidth() && 0 <= aperture.getY() && aperture.getY() + aperture.getHeight() <= this.getHeight());
    }

}
