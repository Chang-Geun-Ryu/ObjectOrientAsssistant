package academy.pocu.comp2500.assignment2;

public class Calendar extends BaseProduct {
    ECalendarType calendarType;

    public Calendar(ECalendarType calendarType, EShippingMethod shippingMethod) {
        super(shippingMethod);
        this.calendarType = calendarType;
        switch (calendarType) {
            case WALL:
                demension = new Demension(400, 400);
                price = 1000;
                break;
            case DESK:
                demension = new Demension(200, 150);
                price = 1000;
                break;
            case MAGNET:
                demension = new Demension(100, 200);
                price = 1500;
                break;
            default:
                assert false;
        }
        color = new Color(0xff, 0xff, 0xff);
    }

    public ECalendarType getCalendarType() {
        return calendarType;
    }
}
