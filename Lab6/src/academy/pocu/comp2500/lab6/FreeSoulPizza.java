package academy.pocu.comp2500.lab6;

public class FreeSoulPizza extends Pizza {
    private static final int PRICE = 25;
    private static final int MAX_MEAT_COUNT = 2;
    private static final int MAX_VEGGIE_COUNT = 2;
    private static final int MIN_CHEESE_COUNT = 1;

    public FreeSoulPizza() {
        super(PRICE);
    }

    public boolean addTopping(Topping topping) {
        if ((isMeat(topping) && this.meatCount >= MAX_MEAT_COUNT)
                || (isVeggie(topping) && this.veggieCount >= MAX_VEGGIE_COUNT)
                || (isCheese(topping) && this.cheeseCount >= MIN_CHEESE_COUNT)) {
            return false;
        }

        this.toppings.add(topping);

        if (isMeat(topping)) {
            ++this.meatCount;
        }

        if (isVeggie(topping)) {
            ++this.veggieCount;
        }

        if (isCheese(topping)) {
            ++this.cheeseCount;
        }

        this.checkAndUpdateValid();

        return true;
    }

    public boolean removeTopping(Topping topping) {
        boolean isRemoved = this.toppings.remove(topping);

        if (isRemoved) {
            if (isMeat(topping)) {
                --this.meatCount;
            }

            if (isVeggie(topping)) {
                --this.veggieCount;
            }

            if (isCheese(topping)) {
                --this.cheeseCount;
            }
        }

        return isRemoved;
    }

    private void checkAndUpdateValid() {
        if (this.meatCount == MAX_MEAT_COUNT
                && this.veggieCount == MAX_VEGGIE_COUNT
                && this.cheeseCount >= MIN_CHEESE_COUNT) {
            super.isValid = true;
        }
    }
}
