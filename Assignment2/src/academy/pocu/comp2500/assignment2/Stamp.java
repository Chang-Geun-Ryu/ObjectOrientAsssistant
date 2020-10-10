package academy.pocu.comp2500.assignment2;

public class Stamp extends BaseProduct {
    private String text;

    public Stamp(EStampColor stampColor, EStampSize stampSize, String text, EShippingMethod shippingMethod) {
        super((shippingMethod));
        this.text = text;
        switch (stampColor) {
            case RED:
                color = new Color(0xff, 0x00, 0x00);
                break;
            case BLUE:
                color = new Color(0x00, 0x00, 0xff);
                break;
            case GREEN:
                color = new Color(0x00, 0x80, 0x00);
                break;
        }

        switch (stampSize) {
            case FOUR_THREE:
                demension = new Demension(40, 30);
                price = 2300;
                break;
            case FIVE_TWO:
                demension = new Demension(50, 20);
                price = 2300;
                break;
            case SEVEN_FOUR:
                demension = new Demension(70, 40);
                price = 2600;
                break;
            default:
                price = -1;
                assert false;
        }
    }

    public String getText() {
        return text;
    }
}
