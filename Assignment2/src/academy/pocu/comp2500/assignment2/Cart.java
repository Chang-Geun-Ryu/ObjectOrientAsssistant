package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Cart {
    private ArrayList<BaseProduct> products;
    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(BaseProduct product) {
        if (product == null) {
            return;
        }
        this.products.add(product);
    }
    public void removeProduct(BaseProduct product) {
        this.products.remove(product);
    }
    public int getTotalPrice() {
        int totalPrice = 0;
        for (BaseProduct product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

}
