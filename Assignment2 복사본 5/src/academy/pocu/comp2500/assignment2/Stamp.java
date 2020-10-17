package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private String text;

    public Stamp(StampColor stampColor, StampSize size, String text, ShippingMethod shippingMethod) {
        super("Stamp", null, 0, 0, 0, shippingMethod);
        switch (stampColor) {
            case RED:
                super.color = new Color(0xFF, 0x00, 0x00);
                break;
            case BLUE:
                super.color = new Color(0x00, 0x00, 0xFF);
                break;
            case GREEN:
                super.color = new Color(0x00, 0x80, 0x00);
                break;
        }

        switch (size) {
            case MM40X30:
                super.width = 40;
                super.height = 30;
                super.price = 2300;
                break;
            case MM50X20:
                super.width = 50;
                super.height = 20;
                super.price = 2300;
                break;
            case MM70X40:
                super.width = 70;
                super.height = 40;
                super.price = 2600;
                break;
        }

        super.displayName = String.format("Stamp (%d mm x %d mm)", super.width, super.height);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
