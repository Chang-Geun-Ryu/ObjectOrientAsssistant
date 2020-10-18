package academy.pocu.comp2500.assignment2;

public class DoubleCard extends Card {
    public DoubleCard(PaperType paperType, PaperColor paperColor, Orientation orientation, DeliveryMethod deliveryMethod) {
        super(paperType, paperColor, orientation, CardSides.DOUBLE, deliveryMethod);
    }
}
