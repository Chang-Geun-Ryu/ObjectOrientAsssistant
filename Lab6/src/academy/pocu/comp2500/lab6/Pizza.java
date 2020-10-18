package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza extends Food {

    protected ArrayList<Topping> toppings;
    protected int veggieCount;
    protected int meatCount;
    protected int cheeseCount;

    protected Pizza(int price) {
        super(price);
        this.toppings = new ArrayList<Topping>();
    }

    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    public int getCheeseCount() {
        return cheeseCount;
    }

    public int getMeatCount() {
        return meatCount;
    }

    public int getVeggieCount() {
        return veggieCount;
    }
}
