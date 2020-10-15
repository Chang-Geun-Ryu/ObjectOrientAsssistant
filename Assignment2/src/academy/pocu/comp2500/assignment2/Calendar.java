package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType type;

    public Calendar(CalendarType calendarType, ShippingOptionsType deliveryMethod) {
        super();
        this.type = calendarType;
        setName(calendarType.getName());
        setPrice(calendarType.getPrice());
        setWidth(type.getWidth());
        setHeight(type.getHeight());
//        setColor(0xFFFFFF);
        if (deliveryMethod == null) {

        } else {
            setDeliveryMethod(deliveryMethod);
        }
    }

    public CalendarType getType() {
        return this.type;
    }

    public int getColor() {
        return 0xFFFFFF;
    }

//    public int getWidth() {
//        return this.type.getWidth();
//    }
//
//    public int getHeight() {
//        return this.type.getHeight();
//    }
}