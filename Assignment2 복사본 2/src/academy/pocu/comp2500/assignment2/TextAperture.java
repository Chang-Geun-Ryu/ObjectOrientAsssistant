package academy.pocu.comp2500.assignment2;

public class TextAperture extends Aperture {
    private final String text;

    public TextAperture(String text, int width, int height, int x, int y) {
        super(width, height, x, y);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    boolean isTextCorrect(Product product) {
        return this.text != null && isApertureCorrect(product);
    }
}
