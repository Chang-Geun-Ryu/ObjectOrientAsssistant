package academy.pocu.comp2500.lab6;

public class VeggiePizza extends Pizza {
    private static final int PRICE = 17;
    private static final int MAX_CHEESE_COUNT = 2;

    private int cheeseCount;

    public VeggiePizza() {
        super(PRICE);

        super.toppings.add(Topping.BLACK_OLIVES);
        super.toppings.add(Topping.RED_ONIONS);
        super.toppings.add(Topping.GREEN_PEPPERS);
    }

    public boolean addMozzarellaCheese() {
        if (isValid()) {
            return false;
        }

        super.toppings.add(Topping.MOZZARELLA_CHEESE);
        ++this.cheeseCount;

        this.checkAndUpdateValid();

        return true;
    }

    public boolean removeMozzarellaCheese() {
        boolean isRemoved = super.toppings.remove(Topping.MOZZARELLA_CHEESE);

        if (isRemoved) {
            --this.cheeseCount;
            super.updateToInvalid();
        }

        return isRemoved;
    }

    public boolean addCheddarCheese() {
        if (isValid()) {
            return false;
        }

        super.toppings.add(Topping.CHEDDAR_CHEESE);
        ++this.cheeseCount;

        this.checkAndUpdateValid();

        return true;
    }

    public boolean removeCheddarCheese() {
        boolean isRemoved = super.toppings.remove(Topping.CHEDDAR_CHEESE);

        if (isRemoved) {
            --this.cheeseCount;
            super.updateToInvalid();
        }

        return isRemoved;
    }

    public boolean addFetaCheese() {
        if (isValid()) {
            return false;
        }

        super.toppings.add(Topping.FETA_CHEESE);
        ++this.cheeseCount;

        this.checkAndUpdateValid();

        return true;
    }

    public boolean removeFetaCheese() {
        boolean isRemoved = super.toppings.remove(Topping.FETA_CHEESE);

        if (isRemoved) {
            --this.cheeseCount;
            super.updateToInvalid();
        }

        return isRemoved;
    }

    private void checkAndUpdateValid() {
        if (this.cheeseCount == MAX_CHEESE_COUNT) {
            super.isValid = true;
        }
    }
}
