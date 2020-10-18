package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    enum CalendarType {
        WALL,
        DESK,
        MAGNET
    }

    private CalendarType calendarType;

    public Calendar(CalendarType calendarType, ShippingMethod shippingMethod) {
        super(255, 255, 255, getWidth(calendarType), getHeight(calendarType), getPrice(calendarType), shippingMethod);

        this.calendarType = calendarType;
    }

    private static int getWidth(CalendarType calendarType) {
        if (calendarType == CalendarType.WALL) {
            return 400;
        } else if (calendarType == CalendarType.DESK) {
            return 200;
        } else {
            return 100;
        }
    }

    private static int getHeight(CalendarType calendarType) {
        if (calendarType == CalendarType.WALL) {
            return 400;
        } else if (calendarType == CalendarType.DESK) {
            return 150;
        } else {
            return 200;
        }
    }

    private static int getPrice(CalendarType calendarType) {
        if (calendarType == CalendarType.MAGNET) {
            return 1500;
        }

        return 1000;
    }

    public CalendarType getCalendarType() {
        return calendarType;
    }
}
