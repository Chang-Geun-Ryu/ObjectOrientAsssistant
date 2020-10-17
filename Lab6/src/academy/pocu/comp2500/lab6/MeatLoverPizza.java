package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class MeatLoverPizza extends Pizza {

    public MeatLoverPizza() {
        super(21, 1, 4, 1);
        super.addTopping(Topping.BACON);
        super.addTopping(Topping.PEPERONI);
        super.addTopping(Topping.HAM);
        super.addTopping(Topping.SAUSAGES);
        super.addTopping(Topping.CHEDDAR_CHEESE);
    }

    public boolean addBlackOlives() {
        if (possibleToppingList.get(Topping.BLACK_OLIVES)) {
            return this.addTopping(Topping.BLACK_OLIVES);
        }
        return false;
    }

    public boolean removeBlackOlives() {
        return super.removeTopping(Topping.BLACK_OLIVES);
    }

    public boolean addRedOnions() {
        if (possibleToppingList.get(Topping.RED_ONIONS)) {
            return this.addTopping(Topping.RED_ONIONS);
        }
        return false;
    }

    public boolean removeRedOnions() {
        return super.removeTopping(Topping.RED_ONIONS);
    }

    public boolean addGreenPeppers() {
        if (possibleToppingList.get(Topping.GREEN_PEPPERS)) {
            return this.addTopping(Topping.GREEN_PEPPERS);
        }
        return false;

    }

    public boolean removeGreenPeppers() {
        return super.removeTopping(Topping.GREEN_PEPPERS);
    }

}
