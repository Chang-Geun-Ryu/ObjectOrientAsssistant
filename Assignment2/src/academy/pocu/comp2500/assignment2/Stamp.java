package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private String text;

//    public enum StampColor {
//        RED, GREEN, BLUE;
//    }

//    public enum StampSize {
//        W4_H3, W5_H2, W7_H4;
//    }

    public Stamp(StampSize stampSize, StampColor stampColor, String text) {
        super();

        switch (stampSize) {
            case W4_H3:
                super.size = new Size(40, 30);
                super.price = 2300;
                break;
            case W5_H2:
                super.size = new Size(50, 20);
                super.price = 2300;
                break;
            case W7_H4:
                super.size = new Size(70, 40);
                super.price = 2600;
                break;
        }

        switch (stampColor) {
            case RED:
                super.color = new Color(Integer.valueOf("FF", 16), Integer.valueOf("00", 16), Integer.valueOf("00", 16));
//                super.color = new Color(0xFF, 0x00, 0x00);
                break;
            case BLUE:
                super.color = new Color(Integer.valueOf("00", 16), Integer.valueOf("00", 16), Integer.valueOf("FF", 16));
//                super.color = new Color(0x00, 0x00, 0xFF);
                break;
            case GREEN:
                super.color = new Color(Integer.valueOf("00", 16), Integer.valueOf("80", 16), Integer.valueOf("00", 16));
//                super.color = new Color(0xFF, 0x80, 0x00);
                break;
        }

        this.text = text;
        super.displayName = String.format("%s (%.0f mm x %.0f mm)", "Stamp", super.size.getWidth(), super.size.getHeight());
    }

    public String getText() {
        return text;
    }

}

