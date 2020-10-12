package academy.pocu.comp2500.lab6;

public class HousePizza extends Pizza {

    public HousePizza() {
        super(MenuPrice.HOUSE_PIZZA);
    }

    public boolean addBacon() {
        return super.addToppings(Topping.BACON);
    }

    public boolean removeBacon() {
        return super.removeToppings(Topping.BACON);
    }

    public boolean addPeperoni() {
        return super.addToppings(Topping.PEPERONI);
    }

    public boolean removePeperoni() {
        return super.removeToppings(Topping.PEPERONI);
    }

    public boolean addSausages() {
        return super.addToppings(Topping.SAUSAGES);
    }

    public boolean removeSausages() {
        return super.removeToppings(Topping.SAUSAGES);
    }
}
