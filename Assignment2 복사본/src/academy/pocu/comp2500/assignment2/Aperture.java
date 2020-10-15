package academy.pocu.comp2500.assignment2;

public class Aperture {
    protected String text;
    protected int x;
    protected int y;
    protected Demension demension;

    protected Aperture(String text, int x, int y, Demension size) {
        this.text = text;
        this.x = x;
        this.y = y;
        demension = size;
    }

    //getter,setter
    //setter
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    //getter
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Demension getDemension() {
        return demension;
    }
}
