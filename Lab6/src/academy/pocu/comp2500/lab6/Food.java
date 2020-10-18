package academy.pocu.comp2500.lab6;

public class Food {
    protected int price;
    protected boolean isValid;

    protected Food(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isValid() {
        return this.isValid;
    }

    protected void updateToInvalid() {
        this.isValid = false;
    }
}
