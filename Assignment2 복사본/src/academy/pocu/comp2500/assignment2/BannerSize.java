package academy.pocu.comp2500.assignment2;

public enum BannerSize {
    CM_100X50(1000, 500),
    CM_100X100(1000, 1000),
    CM_200X50(2000, 500),
    CM_300X100(3000, 1000);

    private int width;
    private int height;

    private BannerSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
