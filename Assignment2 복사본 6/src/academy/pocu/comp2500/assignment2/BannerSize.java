package academy.pocu.comp2500.assignment2;

public enum BannerSize {
    SMALL(100, 50),
    MIDIUM(100, 100),
    LARGE(200, 50),
    VERY_LARGE(300, 100);

    private final Size size;

    private BannerSize(int width, int height) {
        this.size = new Size(width, height);
    }

    public Size getSize() {
        return size;
    }
}