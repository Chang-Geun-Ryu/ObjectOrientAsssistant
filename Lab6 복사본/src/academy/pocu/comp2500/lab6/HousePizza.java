package academy.pocu.comp2500.lab6;

public class HousePizza extends Pizza {
    private static final int MAX_MEAT_COUNT = 2;

    private int meatCount;

    public HousePizza() {
        super(20, 4 + MAX_MEAT_COUNT);
        super.toppings.add(Topping.BLACK_OLIVES);
        super.toppings.add(Topping.RED_ONIONS);
        super.toppings.add(Topping.GREEN_PEPPERS);
        super.toppings.add(Topping.MOZZARELLA_CHEESE);
        this.meatCount = 0;
    }

    public boolean addBacon() {
        if (isValid()) {
            return false;
        }
        super.toppings.add(Topping.BACON);
        ++this.meatCount;
        if (this.meatCount == MAX_MEAT_COUNT) {
            super.valid = true;
        }
        return true;
    }

    public boolean removeBacon() {
        boolean isRemoved = super.toppings.remove(Topping.BACON);
        if (isRemoved) {
            --this.meatCount;
            super.valid = false;
        }
        return isRemoved;
    }

    public boolean addPeperoni() {
        if (isValid()) {
            return false;
        }
        super.toppings.add(Topping.PEPERONI);
        ++this.meatCount;
        if (this.meatCount == MAX_MEAT_COUNT) {
            super.valid = true;
        }
        return true;
    }

    public boolean removePeperoni() {
        boolean isRemoved = super.toppings.remove(Topping.PEPERONI);
        if (isRemoved) {
            --this.meatCount;
            super.valid = false;
        }
        return isRemoved;
    }

    public boolean addSausages() {
        if (isValid()) {
            return false;
        }
        super.toppings.add(Topping.SAUSAGES);
        ++this.meatCount;
        if (this.meatCount == MAX_MEAT_COUNT) {
            super.valid = true;
        }
        return true;
    }

    public boolean removeSausages() {
        boolean isRemoved = super.toppings.remove(Topping.SAUSAGES);
        if (isRemoved) {
            --this.meatCount;
            super.valid = false;
        }
        return isRemoved;
    }
}