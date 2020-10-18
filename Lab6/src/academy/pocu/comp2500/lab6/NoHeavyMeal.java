package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class NoHeavyMeal extends Meal {
    private static final int PRICE = 15;

    public NoHeavyMeal() {
        super(PRICE);

        super.mealType = MealType.NO_HEAVY_MEAL;
    }

    public void setAppetizers(Appetizer appetizer1, Appetizer appetizer2) {
        this.appetizers.clear();

        this.appetizers.add(appetizer1);
        this.appetizers.add(appetizer2);

        super.checkAndUpdateValid();
    }
}
