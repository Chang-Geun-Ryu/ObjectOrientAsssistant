package academy.pocu.comp2500.assignment2;

public class PortraitBanner extends Banner {
    public PortraitBanner(BannerType bannerType, BannerSize bannerSize, Color color, DeliveryMethod deliveryMethod) {
        super(bannerType, bannerSize, color, Orientation.PORTRAIT, deliveryMethod);
    }
}
