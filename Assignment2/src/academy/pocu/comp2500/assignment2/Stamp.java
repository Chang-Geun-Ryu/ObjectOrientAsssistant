package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private String text;
    private StampColor stampColor;
    private StampSize stampSize;
    private int addPriceBySize = 0;

    public Stamp(StampSize stampSize, StampColor stampColor, String text, DeliveryMethod deliveryMethod) {
        super("Stamp", 0, 0, null, 2300, deliveryMethod);
        setStampSize(stampSize);
        setStampColor(stampColor);
        setText(text);
    }

    protected void setStampColor(StampColor stampColor) {
        this.stampColor = stampColor;
        if (this.stampColor == StampColor.BLUE) {
            setColor("BLUE");
        } else if (this.stampColor == StampColor.GREEN) {
            setColor("GREEN");
        } else if (this.stampColor == StampColor.RED) {
            setColor("RED");
        }
    }

    protected void setStampSize(StampSize stampSize) {
        addPrice(-addPriceBySize);
        this.addPriceBySize = 0;
        this.stampSize = stampSize;
        if (this.stampSize == StampSize.SIZE_4X3) {
            setWidth(40);
            setHeight(30);
        } else if (this.stampSize == StampSize.SIZE_5X2) {
            setWidth(50);
            setHeight(20);
        } else if (this.stampSize == StampSize.SIZE_7X4) {
            setWidth(70);
            setHeight(40);
            this.addPriceBySize = 300;
            addPrice(addPriceBySize);
        }
    }

    public String getText() {
        return text;
    }

    protected void setText(String text) {
        this.text = text;
    }

    public StampColor getStampColor() {
        return stampColor;
    }

    public StampSize getStampSize() {
        return stampSize;
    }
}
