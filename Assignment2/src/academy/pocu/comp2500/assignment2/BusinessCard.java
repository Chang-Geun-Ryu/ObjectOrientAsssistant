package academy.pocu.comp2500.assignment2;

public class BusinessCard extends CustomizableProduct {
    private BusinessCardType type;
    private BusinessCardPrintType cardSides;
    private ProductColor color;

    public BusinessCard(ShippingMethod shippingMethod, BusinessCardType type, BusinessCardPrintType cardSides, Orientation orientation, ProductColor color) {
        super(shippingMethod, orientation);
        this.type = type;
        this.cardSides = cardSides;
        this.color = color;
        this.setColor(color);
        this.setSize();
        this.setName(type);
        this.setPrice(type, cardSides);
    }

    public enum BusinessCardType {
        LINEN,
        LAID,
        SMOOTH
    }

    public enum BusinessCardPrintType {
        SINGLE,
        DOUBLE
    }

    public BusinessCardType getType() {
        return this.type;
    }

    public BusinessCardPrintType getPrintType() {
        return this.cardSides;
    }

    public ProductColor getProductColor() {
        return this.color;
    }

    private void setColor(ProductColor color) {
        switch (color) {
            case GRAY:
                super.red = 0xe6;
                super.green = 0xe6;
                super.blue = 0xe6;
                break;
            case IVORY:
                super.red = 0xff;
                super.green = 0xff;
                super.blue = 0xf0;
                break;
            case WHITE:
                super.red = 0xff;
                super.green = 0xff;
                super.blue = 0xff;
                break;
        }
    }

    private void setSize() {
        super.length = 90;
        super.height = 50;
    }

    private void setName(BusinessCardType type) {
        String name = "";
        switch (type) {
            case LINEN:
                name = "Linen";
                break;
            case LAID:
                name = "Laid";
                break;
            case SMOOTH:
                name = "Smooth";
                break;
        }

        super.name = String.format("%s Business Card", name);
    }


    private void setPrice(BusinessCardType type, BusinessCardPrintType cardSides) {
        int price = 0;
        switch (type) {
            case LINEN:
                price = 110;
                break;
            case LAID:
                price = 120;
                break;
            case SMOOTH:
                price = 100;
                break;
        }

        super.price = (cardSides == BusinessCardPrintType.DOUBLE) ? (price + 30) : price;
    }
}
