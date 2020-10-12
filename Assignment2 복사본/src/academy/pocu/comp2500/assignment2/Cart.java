package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public boolean removeProduct(Product product) {
        return products.remove(product);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
