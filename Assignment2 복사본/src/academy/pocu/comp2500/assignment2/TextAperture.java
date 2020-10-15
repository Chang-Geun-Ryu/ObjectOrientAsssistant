package academy.pocu.comp2500.assignment2;

public class TextAperture extends Aperture {
    public TextAperture(String text, int x, int y, Demension size) {
        super(text, x, y, size);
    }

    public String getText() {
        return text;
    }
}
