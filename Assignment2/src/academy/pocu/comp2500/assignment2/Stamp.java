package academy.pocu.comp2500.assignment2;

public class Stamp extends BaseProduct {
    private String text;
    private StampSize stampSize;

    public Stamp(String text, StampColor stampColor, StampSize stampSize, ShippingMethod shippingMethod) {
        super(shippingMethod);
        this.text = text;
        this.stampSize = stampSize;

        int[] sizes = this.getStampSizes(stampSize);
        Size size = new Size(sizes[0], sizes[1]);
        super.setSize(size);

        switch (stampSize) {
            case FOUR_BY_THREE:
                super.setDisplayName("Stamp (40 mm x 30 mm)");
                super.setPrice(2300);
                break;
            case FIVE_BY_TWO:
                super.setDisplayName("Stamp (50 mm x 20 mm)");
                super.setPrice(2300);
                break;
            case SEVEN_BY_FOUR:
                super.setDisplayName("Stamp (70 mm x 40 mm)");
                super.setPrice(2600);
                break;
        }



        Color color;
        switch (stampColor) {
            case RED:
                color = new Color(0xFF, 0x0, 0x0);
                super.setColor(color);
                break;
            case GREEN:
                color = new Color(0x0, 0x80, 0x0);
                super.setColor(color);
                break;
            case BLUE:
                color = new Color(0x0, 0x0, 0xFF);
                super.setColor(color);
                break;
        }
    }


    private int[] getStampSizes(StampSize stampSize) {
        int[] size = new int[2];
        switch (stampSize) {
            case FOUR_BY_THREE:
                size[0] = 40;
                size[1] = 30;
                break;
            case FIVE_BY_TWO:
                size[0] = 50;
                size[1] = 20;
                break;
            case SEVEN_BY_FOUR:
                size[0] = 70;
                size[1] = 40;
                break;
        }
        return size;
    }

    public String getText() {
        return this.text;
    }

}
