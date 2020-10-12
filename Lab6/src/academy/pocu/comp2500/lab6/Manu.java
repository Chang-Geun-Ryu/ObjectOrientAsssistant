package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Manu {
    protected static final int MAX_MEAT_COUNT = 2;
    protected static final int MAX_VEGGIE_COUNT = 2;
    protected static final int MAX_CHEESE_COUNT = 2;
    protected MenuPrice price;

    protected int veggieCount;
    protected int meatCount;
    protected boolean isCheeseAdded;
    protected boolean isVeggieAdded;
    protected int cheeseCount;

    protected ArrayList<Appetizer> appetizers = new ArrayList<>();
    protected ArrayList<Dessert> desserts = new ArrayList<>();
//    protected ArrayList<MainCourse> mainCourses = new ArrayList<>();
    protected MainCourse mainCourse;
    protected Dessert dessert;
    protected Appetizer appetizer;

    protected boolean isValid = false;

    protected Manu(MenuPrice price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price.getPrice();
    }

    public boolean isValid() {
        switch (this.price) {
            case HOUSE_PIZZA:
                return this.meatCount == MAX_MEAT_COUNT;
            case VEGGIE_PIZZA:
                return this.cheeseCount == MAX_CHEESE_COUNT;
            case MEAT_LOVER_PIZZA:
                return this.isVeggieAdded;
            case FREE_SOUL_PIZZA:
                return this.meatCount == MAX_MEAT_COUNT
                        && this.veggieCount == MAX_VEGGIE_COUNT
                        && this.isCheeseAdded;
            case NO_HEAVY_MEAL:
                return this.appetizers.size() == 2 && this.dessert != null;
            case DEATH_BY_DESSERTS:
                return this.isValid;
            case THREE_COURSE_MEAL:
                return this.mainCourse != null && this.dessert != null && this.appetizer != null;
            default:
                assert (true) : "IT IS NOT Menu";
                return false;
        }
    }
}
