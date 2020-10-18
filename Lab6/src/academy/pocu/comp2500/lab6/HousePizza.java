package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class HousePizza extends Pizza {
    private static final int PRICE = 20;
    private static final int MAX_MEAT_COUNT = 2;

    public HousePizza() {
        super(PRICE);

        super.toppings.add(Topping.BLACK_OLIVES);
        super.toppings.add(Topping.RED_ONIONS);
        super.toppings.add(Topping.GREEN_PEPPERS);
        super.toppings.add(Topping.MOZZARELLA_CHEESE);
    }

    public boolean addBacon() {
        if (super.isValid) {
            return false;
        }

        super.toppings.add(Topping.BACON);
        ++super.meatCount;

        this.checkAndUpdateValid();

        return true;
    }

    public boolean removeBacon() {
        boolean isRemoved = super.toppings.remove(Topping.BACON);

        if (isRemoved) {
            --super.meatCount;
            super.updateToInvalid();
        }

        return isRemoved;
    }

    public boolean addPeperoni() {
        if (isValid()) {
            return false;
        }

        super.toppings.add(Topping.PEPERONI);
        ++super.meatCount;

        this.checkAndUpdateValid();

        return true;
    }

    public boolean removePeperoni() {
        boolean isRemoved = super.toppings.remove(Topping.PEPERONI);

        if (isRemoved) {
            --super.meatCount;
            super.updateToInvalid();
        }

        return isRemoved;
    }

    public boolean addSausages() {
        if (isValid()) {
            return false;
        }

        super.toppings.add(Topping.SAUSAGES);
        ++super.meatCount;
        this.checkAndUpdateValid();

        return true;
    }

    public boolean removeSausages() {
        boolean isRemoved = super.toppings.remove(Topping.SAUSAGES);

        if (isRemoved) {
            --super.meatCount;
            super.updateToInvalid();
        }

        return isRemoved;
    }

    private void checkAndUpdateValid() {
        if (super.meatCount == MAX_MEAT_COUNT) {
            super.isValid = true;
        }
    }
}
