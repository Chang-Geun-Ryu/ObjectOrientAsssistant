package academy.pocu.comp2500.assignment2;

public class GrayCard extends Card {
    public GrayCard(PaperType paperType, Orientation orientation, CardSides cardSides, DeliveryMethod deliveryMethod) {
        super(paperType, PaperColor.GRAY, orientation, cardSides, deliveryMethod);
    }
}
