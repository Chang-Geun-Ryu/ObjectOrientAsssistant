package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Menu {
    protected int price;
    protected boolean valid;

    protected Menu(int price) {
        this.price = price;
        this.valid = false;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isValid() {
        return this.valid;
    }

    protected ToppingType getType(Topping topping) {
        if (topping == Topping.CHICKEN) {
            return ToppingType.MEAT;
        } else if (topping == Topping.PEPERONI) {
            return ToppingType.MEAT;
        } else if (topping == Topping.SAUSAGES) {
            return ToppingType.MEAT;
        } else if (topping == Topping.HAM) {
            return ToppingType.MEAT;
        } else if (topping == Topping.BACON) {
            return ToppingType.MEAT;
        } else if (topping == Topping.BLACK_OLIVES) {
            return ToppingType.VEGGIE;
        } else if (topping == Topping.RED_ONIONS) {
            return ToppingType.VEGGIE;
        } else if (topping == Topping.GREEN_PEPPERS) {
            return ToppingType.VEGGIE;
        } else if (topping == Topping.MOZZARELLA_CHEESE) {
            return ToppingType.CHEESE;
        } else if (topping == Topping.CHEDDAR_CHEESE) {
            return ToppingType.CHEESE;
        } else {
            return ToppingType.CHEESE;
        }

    }
}
