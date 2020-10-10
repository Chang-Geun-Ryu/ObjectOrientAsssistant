package academy.pocu.comp2500.assignment2;

public class ImageAperture extends Aperture {
    public ImageAperture(String imagePath, int x, int y, Demension size) {
        super(imagePath, x, y, size);
    }

    public String getImagePath() {
        return text;
    }
}
