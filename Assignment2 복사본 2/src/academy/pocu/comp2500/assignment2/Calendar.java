package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType calendarType;

    public Calendar(CalendarType calendarType, Delivery delivery) {
        super(delivery);
        super.r = 255;
        super.g = 255;
        super.b = 255;
        this.calendarType = calendarType;

        switch (calendarType) {
            case WALL: {
                super.name = "Wall Calendar";
                super.width = 400;
                super.height = 400;
                super.price = 1000;
                break;
            }
            case DESK: {
                super.name = "Desk Calendar";
                super.width = 200;
                super.height = 150;
                super.price = 1000;
                break;
            }
            case MAGNET: {
                super.name = "Magnet Calendar";
                super.width = 100;
                super.height = 200;
                super.price = 1500;
                break;
            }
            default: {
                assert (false) : "Enum Error";
            }
        }
    }

    public CalendarType getCalendarType() {
        return calendarType;
    }
}
