package academy.pocu.comp2500.lab6;

public enum Topping {
    CHICKEN(ToppingType.MEAT),
    PEPERONI(ToppingType.MEAT),
    SAUSAGES(ToppingType.MEAT),
    HAM(ToppingType.MEAT),
    BACON(ToppingType.MEAT),
    BLACK_OLIVES(ToppingType.VEGGIE),
    RED_ONIONS(ToppingType.VEGGIE),
    GREEN_PEPPERS(ToppingType.VEGGIE),
    MOZZARELLA_CHEESE(ToppingType.CHEESE),
    CHEDDAR_CHEESE(ToppingType.CHEESE),
    FETA_CHEESE(ToppingType.CHEESE);

    private ToppingType toppingType;

    private Topping(ToppingType toppingType) {
        this.toppingType = toppingType;
    }

    public ToppingType getToppingType() {
        return toppingType;
    }
}
