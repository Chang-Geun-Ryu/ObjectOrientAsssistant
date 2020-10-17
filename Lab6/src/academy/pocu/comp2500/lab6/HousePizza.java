package academy.pocu.comp2500.lab6;

public class HousePizza extends Pizza {

    public HousePizza() {
        super(20, 1, 2, 3);
        super.addTopping(Topping.BLACK_OLIVES);
        super.addTopping(Topping.RED_ONIONS);
        super.addTopping(Topping.GREEN_PEPPERS);
        super.addTopping(Topping.MOZZARELLA_CHEESE);
    }


    public boolean addBacon() {
        if (possibleToppingList.get(Topping.BACON)) {
            return this.addTopping(Topping.BACON);
        }
        return false;
    }

    public boolean removeBacon() {
        return super.removeTopping(Topping.BACON);
    }

    public boolean addPeperoni() {
        if (possibleToppingList.get(Topping.PEPERONI)) {
            return this.addTopping(Topping.PEPERONI);
        }
        return false;
    }

    public boolean removePeperoni() {
        return super.removeTopping(Topping.PEPERONI);
    }

    public boolean addSausages() {
        if (possibleToppingList.get(Topping.SAUSAGES)) {
            return this.addTopping(Topping.SAUSAGES);
        }
        return false;
    }

    public boolean removeSausages() {
        return super.removeTopping(Topping.SAUSAGES);
    }

}
