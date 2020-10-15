package academy.pocu.comp2500.assignment2;

public class ImageAperture extends Aperture {
    private String imagePath;

    public ImageAperture(int x, int y, String imagePath, Size size) {
        super(x, y, size);
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
}
