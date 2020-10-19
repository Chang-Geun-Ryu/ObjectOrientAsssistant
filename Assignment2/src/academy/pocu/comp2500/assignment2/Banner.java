package academy.pocu.comp2500.assignment2;

public class Banner extends CustomizableProduct {
    private BannerType type;
    private BannerSize size;

    public Banner(ShippingMethod shippingMethod, BannerType type, BannerSize size, Orientation orientation, int red, int green, int blue) {
        super(shippingMethod, orientation);
        this.type = type;
        this.size = size;
        this.setColor(red, green, blue);
        this.setSize(size);
        this.setName(type, length, height);
        this.setPrice(type, size);
    }

    public enum BannerType {
        GLOSS,
        SCRIM,
        MESH
    }

    public enum BannerSize {
        SIZE1,
        SIZE2,
        SIZE3,
        SIZE4
    }

    public BannerType getType() {
        return this.type;
    }

    public BannerSize getSize() {
        return this.size;
    }

    private void setColor(int red, int green, int blue) {
        super.red = red;
        super.green = green;
        super.blue = blue;
    }

    private void setSize(BannerSize size) {
        switch (size) {
            case SIZE1:
                super.length = 1000;
                super.height = 500;
                break;
            case SIZE2:
                super.length = 1000;
                super.height = 1000;
                break;
            case SIZE3:
                super.length = 2000;
                super.height = 500;
                break;
            case SIZE4:
                super.length = 3000;
                super.height = 1000;
        }
    }

    private void setName(BannerType type, int length, int height) {
        String name = "";
        switch (type) {
            case GLOSS:
                name = "Gloss";
                break;
            case SCRIM:
                name = "Scrim";
                break;
            case MESH:
                name = "Mesh";
                break;
        }

        super.name = String.format("%s Banner (%d mm x %d mm)", name, length, height);
    }

    private void setPrice(BannerType type, BannerSize size) {
        // get base price
        int price = 0;
        if (type == BannerType.GLOSS) {
            switch (size) {
                case SIZE1:
                    price = 5000;
                    break;
                case SIZE2:
                    price = 5200;
                    break;
                case SIZE3:
                    price = 5300;
                    break;
                case SIZE4:
                    price = 6000;
                    break;
            }
        } else {
            switch (size) {
                case SIZE1:
                    price = 5100;
                    break;
                case SIZE2:
                    price = 5300;
                    break;
                case SIZE3:
                    price = 5400;
                    break;
                case SIZE4:
                    price = 6100;
                    break;
            }
        }

        // get additional price
        int aperturePrice = 5 * this.apertures.size();

        super.price = price + aperturePrice;
    }
}
