package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {

    private StampColor stampColor;
    private StampSize stampSize;
    private String text;

    public Stamp(StampColor stampColor, StampSize stampSize, String textOrNull) {
        super(new Size(0, 0), new Color(0, 0, 0), ShippingMethod.PICK_UP);

        this.stampColor = stampColor;
        this.stampSize = stampSize;
        this.text = textOrNull;

        if (stampColor == StampColor.RED) {
            this.setColor(new Color(0xFF, 0, 0));
        } else if (stampColor == StampColor.GREEN) {
            this.setColor(new Color(0, 0x80, 0));
        } else if (stampColor == StampColor.BLUE) {
            this.setColor(new Color(0, 0, 0xFF));
        }

        if (stampSize == StampSize.SIZE_4_3 || stampSize == StampSize.SIZE_5_2) {
            if (stampSize == StampSize.SIZE_4_3) {
                this.setSize(new Size(40, 30));
            } else {
                this.setSize(new Size(50, 20));
            }
            this.setPrice(2300);
        } else if (stampSize == StampSize.SIZE_7_4) {
            this.setSize(new Size(70, 40));
            this.setPrice(2600);
        }

        super.setName(String.format("Stamp (%d mm x %d mm)", super.getSize().getWidth(), super.getSize().getHeight()));
//        this.setName(String.format("Stamp (%d mm x %d mm)", this.getSize().getWidth(), this.getSize().getHeight()));
    }

    public StampColor getStampColor() {
        return stampColor;
    }

    public StampSize getStampSize() {
        return stampSize;
    }

    public String getText() {
        return text;
    }
}