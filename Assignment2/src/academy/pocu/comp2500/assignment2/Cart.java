package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products = new ArrayList<>();
    private int totalPrice;

    public Cart() {

    }

    public void addProduct(Product product) {
        products.add(product);
        totalPrice += product.getPrice();
    }

    public void removeProduct(Product product) {
        products.remove(product);
        totalPrice -= product.getPrice();
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
