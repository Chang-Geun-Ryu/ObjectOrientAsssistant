package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza extends Manu {
    protected ArrayList<Topping> toppings;

    protected Pizza(MenuPrice price) {
        super(price);
        this.toppings = new ArrayList<>();
        setUpToppings();
    }
    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    private void setUpToppings() {
        switch (super.price) {
            case HOUSE_PIZZA:
                this.toppings.add(Topping.BLACK_OLIVES);
                this.toppings.add(Topping.RED_ONIONS);
                this.toppings.add(Topping.GREEN_PEPPERS);
                this.toppings.add(Topping.MOZZARELLA_CHEESE);
                break;
            case VEGGIE_PIZZA:
                this.toppings.add(Topping.BLACK_OLIVES);
                this.toppings.add(Topping.RED_ONIONS);
                this.toppings.add(Topping.GREEN_PEPPERS);
                break;
            case MEAT_LOVER_PIZZA:
                this.toppings.add(Topping.BACON);
                this.toppings.add(Topping.PEPERONI);
                this.toppings.add(Topping.HAM);
                this.toppings.add(Topping.SAUSAGES);
                this.toppings.add(Topping.CHEDDAR_CHEESE);
                break;
            case FREE_SOUL_PIZZA:
                break;
            default:
                assert (true) : "IT IS NOT Pizza";
        }
    }

    private static boolean isMeat(Topping topping) {
        return topping == Topping.BACON
                || topping == Topping.CHICKEN
                || topping == Topping.PEPERONI
                || topping == Topping.SAUSAGES
                || topping == Topping.HAM;
    }

    private static boolean isVeggie(Topping topping) {
        return topping == Topping.BLACK_OLIVES
                || topping == Topping.RED_ONIONS
                || topping == Topping.GREEN_PEPPERS;
    }

    private static boolean isCheese(Topping topping) {
        return topping == Topping.MOZZARELLA_CHEESE
                || topping == Topping.CHEDDAR_CHEESE
                || topping == Topping.FETA_CHEESE;
    }

    protected boolean addToppings(Topping topping) {
        if (super.price == MenuPrice.FREE_SOUL_PIZZA) {
            if ((isMeat(topping) && this.meatCount >= MAX_MEAT_COUNT)
                    || (isVeggie(topping) && this.veggieCount >= MAX_VEGGIE_COUNT)
                    || (isCheese(topping) && this.isCheeseAdded)) {
                return false;
            }
        } else {
            if (isValid()) {
                return false;
            }
        }

        this.toppings.add(topping);

        if (super.price == MenuPrice.HOUSE_PIZZA) {
            ++this.meatCount;
        } else if (super.price == MenuPrice.VEGGIE_PIZZA) {
            ++this.cheeseCount;
        } else if (super.price == MenuPrice.MEAT_LOVER_PIZZA) {
            this.isVeggieAdded = true;
        } else if (super.price == MenuPrice.FREE_SOUL_PIZZA) {
            if (isMeat(topping)) {
                ++this.meatCount;
            }
            if (isVeggie(topping)) {
                ++this.veggieCount;
            }
            if (isCheese(topping)) {
                this.isCheeseAdded = true;
            }
        }

       return true;
    }

    protected boolean removeToppings(Topping topping) {
        boolean isRemoved = this.toppings.remove(topping);

        if (isRemoved) {
            if (super.price == MenuPrice.HOUSE_PIZZA) {
                --this.meatCount;
            } else if (super.price == MenuPrice.VEGGIE_PIZZA) {
                --this.cheeseCount;
            }else if (super.price == MenuPrice.MEAT_LOVER_PIZZA) {
                this.isVeggieAdded = false;
            } else if (super.price == MenuPrice.FREE_SOUL_PIZZA) {
                if (isMeat(topping)) {
                    --this.meatCount;
                }
                if (isVeggie(topping)) {
                    --this.veggieCount;
                }
                if (isCheese(topping)) {
                    this.isCheeseAdded = false;
                }
            }
        }

        return isRemoved;
    }
}
