package academy.pocu.comp2500.assignment2;

public class WhiteCard extends Card {
    public WhiteCard(PaperType paperType, Orientation orientation, CardSides cardSides, DeliveryMethod deliveryMethod) {
        super(paperType, PaperColor.WHITE, orientation, cardSides, deliveryMethod);
    }
}
