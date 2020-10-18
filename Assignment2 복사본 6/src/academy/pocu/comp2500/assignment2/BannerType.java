package academy.pocu.comp2500.assignment2;

public enum BannerType {
    GLOSS_BANNER("Gloss Banner"),
    SCRIM_BANNER("Scrim Banner"),
    MESH_BANNER("Mesh Banner");

    private final String type;

    BannerType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
