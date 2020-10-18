package academy.pocu.comp2500.assignment2;

public class LaidCard extends Card {
    public LaidCard(PaperColor paperColor, Orientation orientation, CardSides cardSides, DeliveryMethod deliveryMethod) {
        super(PaperType.LAID, paperColor, orientation, cardSides, deliveryMethod);
    }
}
