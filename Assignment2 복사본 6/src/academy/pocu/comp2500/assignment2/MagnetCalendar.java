package academy.pocu.comp2500.assignment2;

public class MagnetCalendar extends Calendar {
    public MagnetCalendar(ShippingMethod shippingMethod) {
        super("Magnet Calendar", new Size(100, 200), 1500, shippingMethod);
    }
}
