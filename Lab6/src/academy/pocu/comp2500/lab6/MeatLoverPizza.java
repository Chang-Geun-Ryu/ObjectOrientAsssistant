package academy.pocu.comp2500.lab6;

public class MeatLoverPizza extends Pizza {
    private static final int PRICE = 21;

    public MeatLoverPizza() {
        super(PRICE);

        super.toppings.add(Topping.BACON);
        super.toppings.add(Topping.PEPERONI);
        super.toppings.add(Topping.HAM);
        super.toppings.add(Topping.SAUSAGES);
        super.toppings.add(Topping.CHEDDAR_CHEESE);
    }

    public boolean addBlackOlives() {
        if (isValid()) {
            return false;
        }

        super.toppings.add(Topping.BLACK_OLIVES);
        super.isValid = true;
        return true;
    }

    public boolean removeBlackOlives() {
        boolean isRemoved = super.toppings.remove(Topping.BLACK_OLIVES);

        if (isRemoved) {
            super.isValid = false;
        }

        return isRemoved;
    }

    public boolean addRedOnions() {
        if (isValid()) {
            return false;
        }

        super.toppings.add(Topping.RED_ONIONS);
        super.isValid = true;
        return true;
    }

    public boolean removeRedOnions() {
        boolean isRemoved = super.toppings.remove(Topping.RED_ONIONS);

        if (isRemoved) {
            super.isValid = false;
        }

        return isRemoved;
    }

    public boolean addGreenPeppers() {
        if (isValid()) {
            return false;
        }

        super.toppings.add(Topping.GREEN_PEPPERS);
        super.isValid = true;
        return true;
    }

    public boolean removeGreenPeppers() {
        boolean isRemoved = super.toppings.remove(Topping.GREEN_PEPPERS);

        if (isRemoved) {
            super.isValid = false;
        }

        return isRemoved;
    }
}
