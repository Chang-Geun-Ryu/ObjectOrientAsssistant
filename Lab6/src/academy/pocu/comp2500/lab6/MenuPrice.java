package academy.pocu.comp2500.lab6;

public enum MenuPrice {
    HOUSE_PIZZA(20),
    MEAT_LOVER_PIZZA(21),
    VEGGIE_PIZZA(17),
    FREE_SOUL_PIZZA(25),
    DEATH_BY_DESSERTS(20),
    NO_HEAVY_MEAL(15),
    THREE_COURSE_MEAL(25);

    private int price;

    public int getPrice() {
        return this.price;
    }

    private MenuPrice(int price) {
        this.price = price;
    }
}
