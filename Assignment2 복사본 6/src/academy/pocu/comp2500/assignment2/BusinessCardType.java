package academy.pocu.comp2500.assignment2;

public enum BusinessCardType {
    LINEN_BUSINESS_CARD("Linen Business Card"),
    LAID_BUSINESS_CARD("Laid Business Card"),
    SMOOTH_BUSINESS_CARD("Smooth Business Card");

    private final String type;

    BusinessCardType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
