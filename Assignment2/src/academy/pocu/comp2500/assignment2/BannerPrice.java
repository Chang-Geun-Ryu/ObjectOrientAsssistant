package academy.pocu.comp2500.assignment2;

public enum BannerPrice {
    GLOSS_SMALL(5000),
    GLOSS_MEDIUM(5200),
    GLOSS_LARGE(5300),
    GLOSS_VERY_LARGE(6000),

    SCRIM_SMALL(5100),
    SCRIM_MEDIUM(5300),
    SCRIM_LARGE(5400),
    SCRIM_VERY_LARGE(6100),

    MESH_SMALL(5100),
    MESH_MEDIUM(5300),
    MESH_LARGE(5400),
    MESH_VERY_LARGE(6100);

    private final int price;

    BannerPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
