package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private TextAperture textAperture;
    private StampSize stampSize;
    private StampColor stampColor;

    public Stamp(StampSize stampSize, StampColor stampColor, DeliveryMethod deliveryMethod) {
        super(getSize(stampSize), getPrice(stampSize), getColor(stampColor), deliveryMethod);
        this.stampSize = stampSize;
        this.stampColor = stampColor;
    }


    static private Color getColor(StampColor stampColor) {
        Color color;
        switch (stampColor) {
            case RED:
                color = new Color(0xFF, 0x00, 0x00);
                break;
            case BLUE:
                color = new Color(0x00, 0x00, 0xFF);
                break;
            case GREEN:
                color = new Color(0x00, 0x80, 0x00);
                break;
            default:
                color = null;
                break;
        }
        return color;
    }

    static private int getPrice(StampSize stampSize) {
        int price = 0;
        switch (stampSize) {
            case SMALL:
            case MEDIUM:
                price = 2300;
                break;
            case LARGE:
                price = 2600;
                break;
        }
        return price;
    }

    static private Size getSize(StampSize stampSize) {
        Size size = null;
        switch (stampSize) {
            case SMALL:
                size = new Size(40, 30);
                break;
            case MEDIUM:
                size = new Size(50, 20);
                break;
            case LARGE:
                size = new Size(70, 40);
                break;
        }
        return size;
    }


    public void setTextAperture(TextAperture textAperture) {
        if (textAperture.getX() + textAperture.getSize().getWidth() <= 0 ||
                textAperture.getX() >= super.size.getWidth()) {
            return;
        }

        if (textAperture.getY() + textAperture.getSize().getHeigth() <= 0 ||
                textAperture.getY() >= super.size.getHeigth()) {
            return;
        }
        this.textAperture = textAperture;
    }

    public TextAperture getTextAperture() {
        return textAperture;
    }

    public StampSize getStampSize() {
        return stampSize;
    }

    public StampColor getStampColor() {
        return stampColor;
    }
}
