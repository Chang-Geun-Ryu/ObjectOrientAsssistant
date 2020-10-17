package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Cart {
    private String title = "PrintIt";
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.price;
        }
        return totalPrice;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
