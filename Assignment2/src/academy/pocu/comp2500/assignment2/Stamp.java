package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    enum StampColor {
        RED,
        BLUE,
        GREEN
    }

    enum StampSize {
        W4H3,
        W5H2,
        W7H4
    }

    private String text;

    public Stamp(StampColor stampColor, StampSize stampSize, ShippingMethod shippingMethod, String text) {
        super(getRed(stampColor), getGreen(stampColor), getBlue(stampColor), getWidth(stampSize), getHeight(stampSize), getPrice(stampSize), shippingMethod);

        this.text = text;
    }

    private static int getRed(StampColor stampColor) {
        if (stampColor == StampColor.RED) {
            return 255;
        }

        return 0;
    }

    private static int getBlue(StampColor stampColor) {
        if (stampColor == StampColor.BLUE) {
            return 255;
        }

        return 0;
    }

    private static int getGreen(StampColor stampColor) {
        if (stampColor == StampColor.GREEN) {
            return 128;
        }

        return 0;
    }

    private static int getWidth(StampSize stampSize) {
        if (stampSize == StampSize.W4H3) {
            return 40;
        } else if (stampSize == StampSize.W5H2) {
            return 50;
        } else {
            return 70;
        }
    }

    private static int getHeight(StampSize stampSize) {
        if (stampSize == StampSize.W4H3) {
            return 30;
        } else if (stampSize == StampSize.W5H2) {
            return 20;
        } else {
            return 40;
        }
    }

    private static int getPrice(StampSize stampSize) {
        if (stampSize == StampSize.W7H4) {
            return 2600;
        }

        return 2300;
    }
}
