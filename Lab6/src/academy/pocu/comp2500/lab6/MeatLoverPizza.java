package academy.pocu.comp2500.lab6;

public class MeatLoverPizza extends Pizza {
    private static final int MAX_VEGGIE_COUNT = 1;

    private int veggieCount;

    public MeatLoverPizza() {
        super(21, 5 + MAX_VEGGIE_COUNT);
        super.toppings.add(Topping.BACON);
        super.toppings.add(Topping.PEPERONI);
        super.toppings.add(Topping.HAM);
        super.toppings.add(Topping.SAUSAGES);
        super.toppings.add(Topping.CHEDDAR_CHEESE);
        this.veggieCount = 0;
    }

    public boolean addBlackOlives() {
        if (isValid()) {
            return false;
        }
        super.toppings.add(Topping.BLACK_OLIVES);
        ++this.veggieCount;
        if (this.veggieCount == MAX_VEGGIE_COUNT) {
            super.valid = true;
        }
        return true;
    }

    public boolean removeBlackOlives() {
        boolean isRemoved = super.toppings.remove(Topping.BLACK_OLIVES);
        if (isRemoved) {
            --this.veggieCount;
            super.valid = false;
        }
        return isRemoved;
    }

    public boolean addRedOnions() {
        if (isValid()) {
            return false;
        }
        super.toppings.add(Topping.RED_ONIONS);
        ++this.veggieCount;
        if (this.veggieCount == MAX_VEGGIE_COUNT) {
            super.valid = true;
        }
        return true;
    }

    public boolean removeRedOnions() {
        boolean isRemoved = this.toppings.remove(Topping.RED_ONIONS);
        if (isRemoved) {
            --this.veggieCount;
            super.valid = false;
        }
        return isRemoved;
    }

    public boolean addGreenPeppers() {
        if (isValid()) {
            return false;
        }
        super.toppings.add(Topping.GREEN_PEPPERS);
        ++this.veggieCount;
        if (this.veggieCount == MAX_VEGGIE_COUNT) {
            super.valid = true;
        }
        return true;
    }

    public boolean removeGreenPeppers() {
        boolean isRemoved = super.toppings.remove(Topping.GREEN_PEPPERS);
        if (isRemoved) {
            --this.veggieCount;
            super.valid = false;
        }
        return isRemoved;
    }
}