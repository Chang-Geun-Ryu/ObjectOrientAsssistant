package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class VeggiePizza extends Pizza {
    private static final int MAX_CHEESE_COUNT = 2;

    private int cheeseCount;

    public VeggiePizza() {
        super(17, 3 + MAX_CHEESE_COUNT);
        super.toppings.add(Topping.BLACK_OLIVES);
        super.toppings.add(Topping.RED_ONIONS);
        super.toppings.add(Topping.GREEN_PEPPERS);
        this.cheeseCount = 0;
    }

    public boolean addMozzarellaCheese() {
        if (isValid()) {
            return false;
        }
        super.toppings.add(Topping.MOZZARELLA_CHEESE);
        ++this.cheeseCount;
        if (this.cheeseCount == MAX_CHEESE_COUNT) {
            super.valid = true;
        }
        return true;
    }

    public boolean removeMozzarellaCheese() {
        boolean isRemoved = this.toppings.remove(Topping.MOZZARELLA_CHEESE);
        if (isRemoved) {
            --this.cheeseCount;
            super.valid = false;
        }
        return isRemoved;
    }

    public boolean addCheddarCheese() {
        if (isValid()) {
            return false;
        }
        super.toppings.add(Topping.CHEDDAR_CHEESE);
        ++this.cheeseCount;
        if (this.cheeseCount == MAX_CHEESE_COUNT) {
            super.valid = true;
        }
        return true;
    }

    public boolean removeCheddarCheese() {
        boolean isRemoved = this.toppings.remove(Topping.CHEDDAR_CHEESE);
        if (isRemoved) {
            --this.cheeseCount;
            super.valid = false;
        }
        return isRemoved;
    }

    public boolean addFetaCheese() {
        if (isValid()) {
            return false;
        }
        super.toppings.add(Topping.FETA_CHEESE);
        ++this.cheeseCount;
        if (this.cheeseCount == MAX_CHEESE_COUNT) {
            super.valid = true;
        }
        return true;
    }

    public boolean removeFetaCheese() {
        boolean isRemoved = this.toppings.remove(Topping.FETA_CHEESE);
        if (isRemoved) {
            --this.cheeseCount;
            super.valid = false;
        }
        return isRemoved;
    }
}