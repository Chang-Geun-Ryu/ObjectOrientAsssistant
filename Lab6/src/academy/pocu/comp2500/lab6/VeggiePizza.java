package academy.pocu.comp2500.lab6;

public class VeggiePizza extends Pizza {
    public VeggiePizza() {
        super(17, 2, 0, 3);
        super.addTopping(Topping.BLACK_OLIVES);
        super.addTopping(Topping.RED_ONIONS);
        super.addTopping(Topping.GREEN_PEPPERS);
    }

    public boolean addMozzarellaCheese() {
        if (possibleToppingList.get(Topping.MOZZARELLA_CHEESE)) {
            return this.addTopping(Topping.MOZZARELLA_CHEESE);
        }
        return false;
    }

    public boolean removeMozzarellaCheese() {
        return super.removeTopping(Topping.MOZZARELLA_CHEESE);
    }

    public boolean addCheddarCheese() {
        if (possibleToppingList.get(Topping.CHEDDAR_CHEESE)) {
            return this.addTopping(Topping.CHEDDAR_CHEESE);
        }
        return false;
    }

    public boolean removeCheddarCheese() {
        return super.removeTopping(Topping.CHEDDAR_CHEESE);
    }

    public boolean addFetaCheese() {
        if (possibleToppingList.get(Topping.FETA_CHEESE)) {
            return this.addTopping(Topping.FETA_CHEESE);
        }
        return false;
    }

    public boolean removeFetaCheese() {
        return super.removeTopping(Topping.FETA_CHEESE);
    }
}
