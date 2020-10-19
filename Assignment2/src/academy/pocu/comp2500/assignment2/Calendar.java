package academy.pocu.comp2500.assignment2;

public class Calendar extends BaseProduct {

    private CalendarType calendarType;

    public Calendar(ShippingMethod shippingMethod, CalendarType calendarType) {
        super(shippingMethod);
        Color calendarColor = new Color(0xFF, 0xFF, 0xFF);
        super.setColor(calendarColor);

        this.calendarType = calendarType;

        Size size;
        switch (calendarType) {
            case DESK_CALENDAR:
                size = new Size(200, 150);
                super.setDisplayName("Desk Calendar");
                super.setSize(size);
                super.setPrice(1000);
                break;
            case WALL_CALENDAR:
                size = new Size(400, 400);
                super.setDisplayName("Wall Calendar");
                super.setSize(size);
                super.setPrice(1000);
                break;
            case MAGNET_CALENDAR:
                size = new Size(100, 200);
                super.setDisplayName("Magnet Calendar");
                super.setSize(size);
                super.setPrice(1500);
                break;
        }
    }

    public CalendarType getCalendarType() {
        return this.calendarType;
    }
}