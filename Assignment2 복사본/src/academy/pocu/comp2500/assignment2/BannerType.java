package academy.pocu.comp2500.assignment2;

public enum BannerType {
    GLOSS("Gloss"),
    SCRIM("Scrim"),
    MESH("Mesh");

    private String name;

    private BannerType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
