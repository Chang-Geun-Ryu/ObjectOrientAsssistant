package academy.pocu.comp2500.lab6;

public class VeggiePizza extends Pizza {

    public VeggiePizza() {
        super(MenuPrice.VEGGIE_PIZZA);
    }

    public boolean addMozzarellaCheese() {
        return super.addToppings(Topping.MOZZARELLA_CHEESE);
    }

    public boolean removeMozzarellaCheese() {
        return super.removeToppings(Topping.MOZZARELLA_CHEESE);
    }

    public boolean addCheddarCheese() {
        return super.addToppings(Topping.CHEDDAR_CHEESE);
    }

    public boolean removeCheddarCheese() {
        return super.removeToppings(Topping.CHEDDAR_CHEESE);
    }

    public boolean addFetaCheese() {
        return super.addToppings(Topping.FETA_CHEESE);
    }

    public boolean removeFetaCheese() {
        return super.removeToppings(Topping.FETA_CHEESE);
    }
}