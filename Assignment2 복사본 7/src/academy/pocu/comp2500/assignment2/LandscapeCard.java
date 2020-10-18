package academy.pocu.comp2500.assignment2;

public class LandscapeCard extends Card {
    public LandscapeCard(PaperType paperType, PaperColor paperColor, CardSides cardSides, DeliveryMethod deliveryMethod) {
        super(paperType, paperColor, Orientation.LANDSCAPE, cardSides, deliveryMethod);
    }
}
