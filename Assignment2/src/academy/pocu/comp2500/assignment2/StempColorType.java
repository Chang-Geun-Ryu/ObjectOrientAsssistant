package academy.pocu.comp2500.assignment2;

public enum StempColorType {
    RED(0xFF0000),
    BLUE(0x0000FF),
    GREEN(0x008000);

    final private int color;

    public int getColor() {
        return color;
    }

    private StempColorType(int color){
        this.color = color;
    }
}