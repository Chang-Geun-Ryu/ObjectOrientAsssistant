package academy.pocu.comp2500.assignment2;

public class SingleCard extends Card {
    public SingleCard(PaperType paperType, PaperColor paperColor, Orientation orientation, DeliveryMethod deliveryMethod) {
        super(paperType, paperColor, orientation, CardSides.SINGLE, deliveryMethod);
    }
}
