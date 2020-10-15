package academy.pocu.comp2500.assignment2;

// 달력
public class Calendar extends Product {

    public enum CalendarType {
        WALL_CALENDAR, MAGNET_CALENDAR, DESK_CALENDAR;
    }

    public Calendar(String productId, CalendarType calendarType) {
        super(productId);

        switch (calendarType) {
            case WALL_CALENDAR:
                super.displayName = "Wall Calendar";
                super.size = new Size(400, 400);
                super.price = 1000;
                super.color = new Color(0xFF, 0xFF, 0xFF);
                break;
            case DESK_CALENDAR:
                super.displayName = "Desk Calendar";
                super.size = new Size(200, 150);
                super.price = 1000;
                super.color = new Color(0xFF, 0xFF, 0xFF);
                break;
            case MAGNET_CALENDAR:
                super.displayName = "Magnet Calendar";
                super.size = new Size(100, 200);
                super.price = 1500;
                super.color = new Color(0xFF, 0xFF, 0xFF);
                break;
        }
    }
}
