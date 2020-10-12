package academy.pocu.comp2500.lab6;

public class MeatLoverPizza extends Pizza {

    public MeatLoverPizza() {
        super(MenuPrice.MEAT_LOVER_PIZZA);
//        super.toppings.add(Topping.BACON);
//        super.toppings.add(Topping.PEPERONI);
//        super.toppings.add(Topping.HAM);
//        super.toppings.add(Topping.SAUSAGES);
//        super.toppings.add(Topping.CHEDDAR_CHEESE);
    }

    public boolean addBlackOlives() {
        return super.addToppings(Topping.BLACK_OLIVES);
    }

    public boolean removeBlackOlives() {
        return super.removeToppings(Topping.BLACK_OLIVES);
    }

    public boolean addRedOnions() {
        return super.addToppings(Topping.RED_ONIONS);
    }

    public boolean removeRedOnions() {
        return super.removeToppings(Topping.RED_ONIONS);
    }

    public boolean addGreenPeppers() {
        return super.addToppings(Topping.GREEN_PEPPERS);
    }

    public boolean removeGreenPeppers() {
        return super.removeToppings(Topping.GREEN_PEPPERS);
    }
}