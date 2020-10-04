package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Banner extends Option {
    private int color;
    private BannerType type;

    public Banner(BannerType type, BannerSize size, int bannerColor, OrientationType orientation, ShippingOptionsType deliveryMethod) {
        super(orientation);
        this.color = bannerColor;
//        super.side = BusinessCardSide.SINGLE;
        this.type = type;
        setName(type.getName() + size.getSize());
        setPrice(size.getPrice() + type.getAddPrice());
        setDeliveryMethod(deliveryMethod);
        setWidth(size.getWidth());
        setHeight(size.getHeight());
//        setColor(color);
    }

    public int getBannerColor() {
        return this.color;
    }

    public BannerType getType() {
        return this.type;
    }
}