package academy.pocu.comp2500.assignment2;

public enum BusinessCardColor {
    GRAY(0xE6E6E6),
    IVORY(0xFFFFF0),
    WHITE(0xFFFFFF);

    final private int color;
    public int getColor() {
        return color;
    }
    private BusinessCardColor(int name){
        this.color = name;
    }
}
