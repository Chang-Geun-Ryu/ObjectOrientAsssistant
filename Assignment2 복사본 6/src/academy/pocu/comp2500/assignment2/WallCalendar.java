package academy.pocu.comp2500.assignment2;

public class WallCalendar extends Calendar {
    public WallCalendar(ShippingMethod shippingMethod) {
        super("Wall Calendar", new Size(400, 400), 1000, shippingMethod);
    }
}
