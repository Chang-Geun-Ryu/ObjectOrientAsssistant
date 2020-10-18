package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class NoHeavyMeal extends Meal {
    private static final int PRICE = 15;

    public NoHeavyMeal() {
        super(PRICE);
    }

    public void setDessert(Dessert dessert) {
        if (this.desserts.size() == 0) {
            this.desserts.add(dessert);
        } else {
            this.desserts.set(0, dessert);
        }
        this.checkAndUpdateValid();
    }

    public void setAppetizers(Appetizer appetizer1, Appetizer appetizer2) {
        this.appetizers.clear();

        this.appetizers.add(appetizer1);
        this.appetizers.add(appetizer2);

        this.checkAndUpdateValid();
    }

    private void checkAndUpdateValid() {
        if (this.appetizers.size() == 2 && this.desserts.size() == 1) {
            super.isValid = true;
        }
    }
}
