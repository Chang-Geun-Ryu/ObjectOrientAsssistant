package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private String text;
    private StempColorType color;

    public Stamp(String text, StempColorType color, StempSizeType stampSize, ShippingOptionsType deliveryMethod) {
        super();

        this.color = color;

        setName("Stamp" + stampSize.getSize());
        setPrice(stampSize.getPrice());

        setDeliveryMethod(deliveryMethod);

        this.text = text;

        setWidth(stampSize.getWidth());
        setHeight(stampSize.getHeight());
    }

    public String getText() {
        return this.text;
    }

    public StempColorType getColor() {
        return this.color;
    }

}
