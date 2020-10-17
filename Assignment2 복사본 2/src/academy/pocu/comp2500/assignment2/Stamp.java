package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private StampType stampType;
    private StampSize stampSize;
    private String textElement;

    public Stamp(StampType stampType, StampSize stampSize, Delivery delivery, String textElement) {
        super(delivery);
        this.stampType = stampType;
        this.stampSize = stampSize;
        this.textElement = textElement;

        switch (stampType) {
            case RED: {
                super.r = 255;
                super.g = 0;
                super.b = 0;
                break;
            }
            case BLUE: {
                super.r = 0;
                super.g = 0;
                super.b = 255;
                break;
            }
            case GREEN: {
                super.r = 0;
                super.g = 80;
                super.b = 0;
                break;
            }
            default: {
                assert (false) : "Enum Error";
            }
        }

        switch (stampSize) {
            case MM40X30: {
                super.width = 40;
                super.height = 30;
                super.price = 2300;
                break;
            }
            case MM50X20: {
                super.width = 50;
                super.height = 20;
                super.price = 2300;
                break;
            }
            case MM70X40: {
                super.width = 70;
                super.height = 40;
                super.price = 2600;
                break;
            }
            default: {
                assert (false) : "Enum Error";
                break;
            }
        }

        super.name = String.format("Stamp (%s mm x %s mm)", super.width, super.height);
    }

    public StampType getStampType() {
        return stampType;
    }

    public void setTextElement(String textElement) {
        this.textElement = textElement;
    }

    public String getTextElement() {
        return textElement;
    }

    public StampSize getStampSize() {
        return stampSize;
    }
}
