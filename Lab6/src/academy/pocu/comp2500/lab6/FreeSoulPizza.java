package academy.pocu.comp2500.lab6;

public class FreeSoulPizza extends Pizza {

    public FreeSoulPizza() {
        super(MenuPrice.FREE_SOUL_PIZZA);
    }

    public boolean addTopping(Topping topping) {
        return super.addToppings(topping);
    }

    public boolean removeTopping(Topping topping) {
        return super.removeToppings(topping);
    }


}