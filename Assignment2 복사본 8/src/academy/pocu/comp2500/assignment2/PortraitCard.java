package academy.pocu.comp2500.assignment2;

public class PortraitCard extends Card {
    public PortraitCard(PaperType paperType, PaperColor paperColor, CardSides cardSides, DeliveryMethod deliveryMethod) {
        super(paperType, paperColor, Orientation.PORTRAIT, cardSides, deliveryMethod);
    }
}
