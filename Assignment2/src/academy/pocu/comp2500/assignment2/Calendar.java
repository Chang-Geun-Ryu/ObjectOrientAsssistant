package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType calendarType;

    public Calendar(CalendarType calendarType, ShippingMethod shippingMethod) {
        super("Calendar", new Color(0xFF, 0xFF, 0xFF), 0, 0, 0, shippingMethod);
        this.calendarType = calendarType;

        switch (calendarType) {
            case WALL:
                super.displayName = "Wall Calendar";
                super.width = 400;
                super.height = 400;
                super.price = 1000;
                break;
            case DESK:
                super.displayName = "Desk Calendar";
                super.width = 200;
                super.height = 150;
                super.price = 1000;
                break;
            case MAGNET:
                super.displayName = "Magnet Calendar";
                super.width = 100;
                super.height = 200;
                super.price = 1500;
                break;
        }
    }

    public CalendarType getCalendarType() {
        return calendarType;
    }
}
