package academy.pocu.comp2500.lab6;

public class MenuItem {
    private final int price;
    protected boolean isValid = false;

    protected MenuItem(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public boolean isValid() {
        return isValid;
    }
}
