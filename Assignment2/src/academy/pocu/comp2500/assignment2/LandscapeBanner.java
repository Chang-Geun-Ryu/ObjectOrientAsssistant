package academy.pocu.comp2500.assignment2;

public class LandscapeBanner extends Banner {
    public LandscapeBanner(BannerType type, Color color, BannerSize size, ShippingMethod shippingMethod) {
        super(type, color, size, Orientation.LANDSCAPE, shippingMethod);
    }
}
