package academy.pocu.comp2500.assignment2;

public class Color {
    public static final Color RED = new Color(0xFF, 0, 0);
    public static final Color BLUE = new Color(0, 0, 0xFF);
    public static final Color GREEN = new Color(0, 0xFF, 0);
    public static final Color GRAY = new Color(0xE6, 0xE6, 0xE6);
    public static final Color IVORY = new Color(0xFF, 0xFF, 0xF0);
    public static final Color WHITE = new Color(0xFF, 0xFF, 0xFF);

    private final int value;

    public Color(int red, int green, int blue) {
        value = ((0xFF) << 24) |
                ((red & 0xFF) << 16) |
                ((green & 0xFF) << 8) |
                ((blue & 0xFF) << 0);
    }

    public int getRgbCode() {
        return value;
    }

    public int getRed() {
        return ((value >> 16) & 0xFF);
    }

    public int getGreen() {
        return ((value >> 8) & 0xFF);
    }

    public int getBlue() {
        return ((value >> 0) & 0xFF);
    }
}
