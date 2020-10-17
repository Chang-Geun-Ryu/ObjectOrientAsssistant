package academy.pocu.comp2500.assignment2;

public class ImageAperture extends Aperture {
    private final String imagePath;

    public ImageAperture(String imagePath, int width, int height, int x, int y) {
        super(width, height, x, y);
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    boolean isImageCorrect(Product product) {
        return this.imagePath != null && isApertureCorrect(product);
    }
}