package academy.pocu.comp2500.lab6;

import java.util.ArrayList;
import java.util.HashMap;


public class Pizza extends Menu {

    private final int MAX_MEAT_COUNT;
    private final int MAX_CHEESE_COUNT;
    private final int MAX_VEGGIE_COUNT;

    protected HashMap<Topping, Boolean> possibleToppingList;

    private ArrayList<Topping> toppings = new ArrayList<>();

    private int veggieCount;
    private int meatCount;
    private int cheeseCount;

    public Pizza(int price, int MAX_CHEESE_COUNT, int MAX_MEAT_COUNT, int MAX_VEGGIE_COUNT) {
        super(price);
        this.MAX_CHEESE_COUNT = MAX_CHEESE_COUNT;
        this.MAX_MEAT_COUNT = MAX_MEAT_COUNT;
        this.MAX_VEGGIE_COUNT = MAX_VEGGIE_COUNT;
        this.possibleToppingList = new HashMap<>();
        for (Topping topping : Topping.values()) {
            this.possibleToppingList.put(topping, true);
        }
    }

    public int getMaxCheeseCount() {
        return MAX_CHEESE_COUNT;
    }

    public int getMaxMeatCount() {
        return MAX_MEAT_COUNT;
    }

    public int getMaxVeggieCount() {
        return MAX_VEGGIE_COUNT;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public boolean addTopping(Topping topping) {
        if (this.isValid()) {
            return false;
        }
        if (possibleToppingList.get(topping)) {
            switch (getToppingCategory(topping)) {
                case MEAT:
                    if (this.meatCount == this.MAX_MEAT_COUNT) {
                        return false;
                    }
                    this.meatCount++;
                    break;
                case CHEESE:
                    if (this.cheeseCount == this.MAX_CHEESE_COUNT) {
                        return false;
                    }
                    this.cheeseCount++;
                    break;
                case VEGGIE:
                    if (this.veggieCount == this.MAX_VEGGIE_COUNT) {
                        return false;
                    }
                    this.veggieCount++;
                    break;
            }
            this.toppings.add(topping);
            return true;
        }
        return false;
    }

    public boolean removeTopping(Topping topping) {
        boolean isRemoved = this.toppings.remove(topping);

        if (isRemoved) {
            ToppingCategory category = this.getToppingCategory(topping);
            switch (category) {
                case VEGGIE:
                    this.veggieCount--;
                    break;
                case CHEESE:
                    this.cheeseCount--;
                    break;
                case MEAT:
                    this.meatCount--;
                    break;
            }
        }
        return isRemoved;
    }

    protected ToppingCategory getToppingCategory(Topping topping) {
        ToppingCategory toppingCategory = ToppingCategory.MEAT;
        switch (topping) {
            case HAM:
            case BACON:
            case PEPERONI:
            case SAUSAGES:
            case CHICKEN:
                break;
            case RED_ONIONS:
            case BLACK_OLIVES:
            case GREEN_PEPPERS:
                toppingCategory = ToppingCategory.VEGGIE;
                break;
            case FETA_CHEESE:
            case CHEDDAR_CHEESE:
            case MOZZARELLA_CHEESE:
                toppingCategory = ToppingCategory.CHEESE;
                break;
        }
        return toppingCategory;
    }

    public boolean isValid() {
        return this.meatCount == MAX_MEAT_COUNT
                && this.veggieCount == MAX_VEGGIE_COUNT
                && this.cheeseCount == MAX_CHEESE_COUNT;
    }




}
