package academy.pocu.comp2500.assignment2;

public class TextAperture extends Aperture {

    public TextAperture(int x, int y, int length, int height, String text) {
        super(x, y, length, height);
        super.type = ApertureType.TEXT;
        this.aperture = text;
    }
}
