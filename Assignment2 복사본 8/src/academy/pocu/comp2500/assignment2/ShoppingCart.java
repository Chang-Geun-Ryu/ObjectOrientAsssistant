package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private ArrayList<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public int getAllPrice() {
        int sumPrice = 0;
        for (Product element : this.products) {
            sumPrice += element.getPrice();
        }
        return sumPrice;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
