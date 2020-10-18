package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<Product>();
    }

    public void addItem(Product product) {
        this.items.add(product);
    }

    public void removeItem(Product product) {
        this.items.remove(product);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < this.items.size(); ++i) {
            Product item = this.items.get(i);
            totalPrice += item.getPrice();
        }

        return totalPrice;
    }
}
