package academy.pocu.comp2500.assignment2;

public class TextAperture extends Aperture {
    private String text;

    public TextAperture(int x, int y, String text, Size size) {
        super(x, y, size);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
