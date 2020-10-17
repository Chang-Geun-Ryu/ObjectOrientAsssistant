package academy.pocu.comp2500.lab6;

public class Menu {
    private int price;
    protected boolean isAdded;

    protected Menu(int price) {
        this.price = price;
        this.isAdded = false;
    }

    public int getPrice() {
        return price;
    }

    public boolean isValid() {
        return isAdded;
    }
}
