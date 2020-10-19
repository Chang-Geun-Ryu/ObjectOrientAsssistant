package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private String aperture;

    public Stamp(ShippingMethod shippingMethod, ProductColor color, StampSize size, String text) {
        super(shippingMethod);
        this.setColor(color);
        this.setSize(size);
        this.setName(super.length, super.height);
        this.aperture = text;
        this.setPrice(size);
    }

    public enum StampSize {
        SIZE1,
        SIZE2,
        SIZE3
    }

    public String getAperture() {
        return this.aperture;
    }

    private void setAperture(String text) {
        this.aperture = text;
    }

    private void setColor(ProductColor color) {
        switch (color) {
            case RED:
                super.red = 255;
                break;
            case BLUE:
                super.blue = 255;
                break;
            case GREEN:
                super.green = 255;
                break;
        }
    }

    private void setSize(StampSize size) {
        switch (size) {
            case SIZE1:
                super.length = 40;
                super.height = 30;
                break;
            case SIZE2:
                super.length = 50;
                super.height = 20;
                break;
            case SIZE3:
                super.length = 70;
                super.height = 40;
                break;
        }
    }

    private void setName(int length, int height) {
        super.name = String.format("Stamp (%d mm x %d mm)", length, height);
    }

    private void setPrice(StampSize size) {
        switch (size) {
            case SIZE1:
            case SIZE2:
                super.price = 2300;
                break;
            case SIZE3:
                super.price = 2600;
                break;
        }
    }
}
