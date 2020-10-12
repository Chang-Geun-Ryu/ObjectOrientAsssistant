package academy.pocu.comp2500.lab6;

public class FreeSoulPizza extends Pizza {
    private static final int MAX_MEAT_COUNT = 2;
    private static final int MAX_VEGGIE_COUNT = 2;
    private static final int MAX_CHEESE_COUNT = 1;

    private int meatCount;
    private int veggieCount;
    private int cheeseCount;

    public FreeSoulPizza() {
        super(25, 5);
        this.meatCount = 0;
        this.veggieCount = 0;
        this.cheeseCount = 0;
    }

    public boolean addTopping(Topping topping) {
        switch (topping.getToppingType()) {
            case MEAT:
                if (this.meatCount >= MAX_MEAT_COUNT) {
                    return false;
                }
                ++this.meatCount;
                break;
            case VEGGIE:
                if (this.veggieCount >= MAX_VEGGIE_COUNT) {
                    return false;
                }
                ++this.veggieCount;
                break;
            case CHEESE:
                if (this.cheeseCount >= MAX_CHEESE_COUNT) {
                    return false;
                }
                ++this.cheeseCount;
                break;
            default:
                assert (false) : "ToppingType is invalid!";
                break;
        }
        super.toppings.add(topping);
        if (this.meatCount == MAX_MEAT_COUNT && this.veggieCount == MAX_VEGGIE_COUNT && this.cheeseCount == MAX_CHEESE_COUNT) {
            super.valid = true;
        }
        return true;
    }

    public boolean removeTopping(Topping topping) {
        boolean isRemoved = this.toppings.remove(topping);
        if (isRemoved) {
            switch (topping.getToppingType()) {
                case MEAT:
                    --this.meatCount;
                    break;
                case VEGGIE:
                    --this.veggieCount;
                    break;
                case CHEESE:
                    --this.cheeseCount;
                    break;
                default:
                    assert (false) : "ToppingType is invalid!";
                    break;
            }
            super.valid = false;
        }
        return isRemoved;
    }
}