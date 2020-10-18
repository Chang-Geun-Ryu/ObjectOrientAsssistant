package academy.pocu.comp2500.assignment2;

public class LandscapeBanner extends Banner {
    public LandscapeBanner(BannerType bannerType, BannerSize bannerSize, Color color, DeliveryMethod deliveryMethod) {
        super(bannerType, bannerSize, color, Orientation.LANDSCAPE, deliveryMethod);
    }
}
