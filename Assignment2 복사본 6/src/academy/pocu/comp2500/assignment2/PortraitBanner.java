package academy.pocu.comp2500.assignment2;

public class PortraitBanner extends Banner {
    public PortraitBanner(BannerType type, Color color, BannerSize size, ShippingMethod shippingMethod) {
        super(type, color, size, Orientation.PORTRAIT, shippingMethod);
    }
}
