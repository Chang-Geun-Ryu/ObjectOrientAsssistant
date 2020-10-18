package academy.pocu.comp2500.lab6;

import java.util.ArrayList;
import java.util.function.Function;

public class Pizza extends MenuItem {
    protected final ArrayList<Topping> toppings = new ArrayList<>();

    protected Pizza(int price) {
        super(price);
    }

    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }
}
