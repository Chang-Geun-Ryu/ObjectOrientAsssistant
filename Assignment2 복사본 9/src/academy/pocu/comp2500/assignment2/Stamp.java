package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private String text;
    public String getText() {
        return text;
    }

    private StampColor stampColor;


    public StampColor getStampColor() {
        return stampColor;
    }

    public Stamp(StampColor stampColor, StampSizeType stampSize, String text) {
        this.text = text;
        this.stampColor = stampColor;

        switch (stampColor) {
            case RED:
                //color = 0xff0000;
                color = new RGB(0xff, 0, 0);
                break;
            case GREEN:
                //color = 0x008000;
                color = new RGB(0, 0x80, 0);
                break;
            case BLUE:
                //color = 0x0000ff;
                color = new RGB(0, 0, 0xff);
                break;
        }
        switch (stampSize) {
            case SIZE_4X3:
//                width = 40;
//                height = 30;
                size = new Size(40, 30);
                price = 2300;
                break;
            case SIZE_5X2:
//                width = 50;
//                height = 20;
                size = new Size(50, 20);
                price = 2300;
                break;
            case SIZE_7X4:
//                width = 70;
//                height = 40;
                size = new Size(70, 40);
                price = 2600;
                break;
        }
        displayName = "Stamp";
        displayName += " (" + getSize().getWidth() + "mm x " + getSize().getHeight() + "mm)";
    }



}
