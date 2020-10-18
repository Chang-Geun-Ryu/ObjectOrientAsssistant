package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType calendarType;
    public Calendar(CalendarType calendarType) {
        super("Calendar", 0, 0, new Color("WHITE"), 1000, DeliveryMethod.PICKUP);
        this.calendarType = calendarType;
        setSize();
        addPriceBySize();
        setDisplayNameByType();
    }

    public CalendarType getCalendarType() {
        return calendarType;
    }

    private void setSize() {
        if (this.calendarType == CalendarType.WALL) {
            setWidth(400);
            setHeight(400);
        } else if (this.calendarType == CalendarType.DESK) {
            setWidth(200);
            setHeight(150);
        } else if (this.calendarType == CalendarType.MAGNET) {
            setWidth(100);
            setHeight(200);
        }
    }

    private void setDisplayNameByType() {
        if (this.calendarType == CalendarType.WALL) {
            setDisplayName("Wall Calendar");
        } else if (this.calendarType == CalendarType.DESK) {
            setDisplayName("Desk Calendar");
        } else if (this.calendarType == CalendarType.MAGNET) {
            setDisplayName("Magnet Calendar");
        }
    }

    private void addPriceBySize() {
        if (this.width == 100 && this.height == 200) {
            addPrice(500);
        }
    }
}
