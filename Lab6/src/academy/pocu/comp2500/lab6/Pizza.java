package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza extends Menu {
    protected ArrayList<Topping> toppings;

    protected Pizza(int price, int toppingCount) {
        super(price);
        this.toppings = new ArrayList<>(toppingCount);
    }

    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }
}
