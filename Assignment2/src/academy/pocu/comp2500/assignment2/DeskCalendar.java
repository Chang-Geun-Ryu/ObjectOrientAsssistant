package academy.pocu.comp2500.assignment2;

public class DeskCalendar extends Calendar {
    public DeskCalendar(ShippingMethod shippingMethod) {
        super("Desk Calendar", new Size(200, 150), 1000, shippingMethod);
    }
}
