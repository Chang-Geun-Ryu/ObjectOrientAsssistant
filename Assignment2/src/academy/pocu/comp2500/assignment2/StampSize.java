package academy.pocu.comp2500.assignment2;

public enum StampSize {
    SMALL(40, 30),
    MIDIUM(50, 20),
    LARGE(70, 40);

    private final Size size;

    StampSize(int width, int height) {
        this.size = new Size(width, height);
    }

    public Size getSize() {
        return size;
    }
}
