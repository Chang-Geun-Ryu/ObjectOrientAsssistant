package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType calendarType;

    public Calendar(CalendarType calendarType) {
        super.setRGB(new RGB(0xFF, 0xFF, 0xFF));
        setCalendarType(calendarType);
    }

    public CalendarType getCalendarType() {
        return this.calendarType;
    }

    private void setCalendarType(CalendarType calendarType) {
        this.calendarType = calendarType;
        super.setName(String.format("%s Calendar", calendarType.getName()));
        super.setWidth(calendarType.getWidth());
        super.setHeight(calendarType.getHeight());
        super.setPrice(calendarType.getPrice());
    }
}
