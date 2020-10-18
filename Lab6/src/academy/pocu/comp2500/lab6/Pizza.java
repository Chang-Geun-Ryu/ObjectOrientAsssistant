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

    protected static boolean isMeat(Topping topping) {
        return topping == Topping.BACON
                || topping == Topping.CHICKEN
                || topping == Topping.PEPERONI
                || topping == Topping.SAUSAGES
                || topping == Topping.HAM;
    }

    protected static boolean isVeggie(Topping topping) {
        return topping == Topping.BLACK_OLIVES
                || topping == Topping.RED_ONIONS
                || topping == Topping.GREEN_PEPPERS;
    }

    protected static boolean isCheese(Topping topping) {
        return topping == Topping.MOZZARELLA_CHEESE
                || topping == Topping.CHEDDAR_CHEESE
                || topping == Topping.FETA_CHEESE;
    }
}
