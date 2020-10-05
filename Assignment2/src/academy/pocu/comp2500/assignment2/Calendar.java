package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType type;

    public Calendar(CalendarType type) {
        super(new Size(0, 0), new Color(0xFF, 0xFF, 0xFF), ShippingMethod.PICK_UP);
        this.type = type;

        if (type == CalendarType.WALL) {
            this.setName("Wall Calendar");
            this.setSize(new Size(400, 400));
            this.setPrice(1000);
        } else if (type == CalendarType.DESK) {
            this.setName("Desk Calendar");
            this.setSize(new Size(200, 150));
            this.setPrice(1000);
        } else if (type == CalendarType.MAGNET) {
            this.setName("Magnet Calendar");
            this.setSize(new Size(100, 200));
            this.setPrice(1500);
        }
    }

    public CalendarType getType() {
        return type;
    }
}
