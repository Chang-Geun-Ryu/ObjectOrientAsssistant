package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private StampColor stampColor;
    private StampSize stampSize;
    private String text;

    public Stamp(StampColor stampColor, StampSize stampSize, String text) {
        this.text = text;
        setStampColor(stampColor);
        setStampSize(stampSize);
    }

    private void calculatePrice() {
        super.setPrice(this.stampSize.getPrice());
    }

    public StampColor getStampColor() {
        return this.stampColor;
    }

    public StampSize getStampSize() {
        return this.stampSize;
    }

    public String getText() {
        return this.text;
    }

    private void setStampColor(StampColor stampColor) {
        this.stampColor = stampColor;
        switch (stampColor) {
            case RED:
                super.setRGB(new RGB(0xFF, 0, 0));
                break;
            case BLUE:
                super.setRGB(new RGB(0, 0, 0xFF));
                break;
            case GREEN:
                super.setRGB(new RGB(0, 0x80, 0));
                break;
            default:
                assert (false) : "StampType is invalid!";
                break;
        }
    }

    private void setStampSize(StampSize stampSize) {
        this.stampSize = stampSize;
        super.setName(String.format("Stamp (%d mm x %d mm)", stampSize.getWidth(), stampSize.getHeight()));
        super.setWidth(stampSize.getWidth());
        super.setHeight(stampSize.getHeight());
        calculatePrice();
    }

    private void setText(String text) {
        this.text = text;
    }
}
