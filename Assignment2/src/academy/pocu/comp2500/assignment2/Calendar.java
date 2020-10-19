package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType type;

    public Calendar(ShippingMethod shippingMethod, CalendarType type) {
        super(shippingMethod);
        this.type = type;
        this.setColor();
        this.setSize(type);
        this.setName(type);
        this.setPrice(type);
    }

    public enum CalendarType {
        WALL,
        DESK,
        MAGNET
    }

    public CalendarType getType() {
        return this.type;
    }

    private void setColor() {
        super.red = 255;
        super.green = 255;
        super.blue = 255;
    }

    private void setSize(CalendarType type) {
        switch (type) {
            case WALL:
                super.length = 400;
                super.height = 400;
                break;
            case DESK:
                super.length = 200;
                super.height = 150;
                break;
            case MAGNET:
                super.length = 100;
                super.height = 200;
                break;
        }
    }

    private void setName(CalendarType type) {
        switch (type) {
            case WALL:
                super.name = "Wall Calendar";
                break;
            case DESK:
                super.name = "Desk Calendar";
                break;
            case MAGNET:
                super.name = "Magnet Calendar";
                break;
        }
    }

    private void setPrice(CalendarType type) {
        switch (type) {
            case WALL:
            case DESK:
                super.price = 1000;
            case MAGNET:
                super.price = 1500;
        }
    }
}
