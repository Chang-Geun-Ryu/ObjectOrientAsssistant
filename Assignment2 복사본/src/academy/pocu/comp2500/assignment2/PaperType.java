package academy.pocu.comp2500.assignment2;

public enum PaperType {
    LINEN("Linen"),
    LAID("Laid"),
    SMOOTH("Smooth");

    private String name;

    private PaperType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
