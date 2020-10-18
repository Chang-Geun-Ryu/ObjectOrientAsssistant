package academy.pocu.comp2500.lab6;

public class VeggiePizza extends Pizza {
    private static final int PRICE = 17;
    private static final int MAX_CHEESE_COUNT = 2;

    private int cheeseCount;

    public VeggiePizza() {
        super(PRICE);
        this.toppings.add(Topping.BLACK_OLIVES);
        this.toppings.add(Topping.RED_ONIONS);
        this.toppings.add(Topping.GREEN_PEPPERS);
    }

    private void setValid() {
        isValid = cheeseCount == MAX_CHEESE_COUNT;
    }

    private void incrementCheeseCount() {
        ++cheeseCount;
        setValid();
    }

    private void decrementCheeseCount() {
        --cheeseCount;
        setValid();
    }

    public boolean addMozzarellaCheese() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.MOZZARELLA_CHEESE);
        incrementCheeseCount();
        return true;
    }

    public boolean removeMozzarellaCheese() {
        boolean isRemoved = this.toppings.remove(Topping.MOZZARELLA_CHEESE);

        if (isRemoved) {
            decrementCheeseCount();
        }

        return isRemoved;
    }

    public boolean addCheddarCheese() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.CHEDDAR_CHEESE);
        incrementCheeseCount();
        return true;
    }

    public boolean removeCheddarCheese() {
        boolean isRemoved = this.toppings.remove(Topping.CHEDDAR_CHEESE);

        if (isRemoved) {
            decrementCheeseCount();
        }

        return isRemoved;
    }

    public boolean addFetaCheese() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.FETA_CHEESE);
        incrementCheeseCount();
        return true;
    }

    public boolean removeFetaCheese() {
        boolean isRemoved = this.toppings.remove(Topping.FETA_CHEESE);

        if (isRemoved) {
            decrementCheeseCount();
        }

        return isRemoved;
    }
}
