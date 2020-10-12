package academy.pocu.comp2500.lab6;

public class NoHeavyMeal extends SetMenu {
    public NoHeavyMeal() {
        super(MenuPrice.NO_HEAVY_MEAL);
    }

    public void setAppetizers(Appetizer appetizer1, Appetizer appetizer2) {
        this.appetizers.clear();

        this.appetizers.add(appetizer1);
        this.appetizers.add(appetizer2);
    }

    public void setDessert(Dessert desert) {
        this.dessert = desert;
    }
}