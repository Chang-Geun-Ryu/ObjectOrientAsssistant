package academy.pocu.comp2500.assignment2;

public enum BusinessCardColor {
    GRAY(Color.GRAY),
    IVORY(Color.IVORY),
    WHITE(Color.WHITE);

    private final Color color;

    BusinessCardColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
