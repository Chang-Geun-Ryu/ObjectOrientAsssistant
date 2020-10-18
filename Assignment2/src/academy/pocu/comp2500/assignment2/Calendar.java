package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType calendarType;
    public CalendarType getCalendarType() {
        return calendarType;
    }

    public Calendar(CalendarType calendarType) {
        this.calendarType = calendarType;
        color = new RGB(0xff, 0xff, 0xff);
        //color = 0xffffff;
        switch (calendarType) {
            case WALL:
                displayName = "Wall Calendar";
//                width = 400;
//                height = 400;
                size = new Size(400, 400);
                price = 1000;
                break;
            case DESK:
                displayName = "Desk Calendar";
//                width = 200;
//                height = 150;
                size = new Size(200, 150);

                price = 1000;
                break;
            case MAGNET:
                displayName = "Magnet Calendar";
//                width = 100;
//                height = 200;
                size = new Size(100, 200);

                price = 1500;
                break;
            default:
                displayName = "Calendar";
                price = 0;
        }


    }

}
