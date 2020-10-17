package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class NoHeavyMeal extends Combo {
    private static final int PRICE = 15;

    public NoHeavyMeal() {
        super(PRICE);
    }

    private boolean isMax() {
        return super.appetizers.size() == 2 && super.desserts.size() != 0;
    }

    public void setAppetizers(Appetizer appetizer1, Appetizer appetizer2) {
        super.appetizers.clear();

        super.appetizers.add(appetizer1);
        super.appetizers.add(appetizer2);
        super.isAdded = isMax();
    }

    public void setDessert(Dessert dessert) {
        if (super.desserts.size() == 0) {
            super.desserts.add(dessert);
        } else {
            super.desserts.set(0, dessert);
        }

        super.isAdded = isMax();
    }
}
