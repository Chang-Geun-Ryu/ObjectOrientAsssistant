package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Cart {
    private final ArrayList<Product> products;
    private int totalPrice;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }

        totalPrice += product.getPrice();

        products.add(product);
    }

    public void removeProduct(int index) { // index 대신 Product를 받아도 됨.
        if (!(index >= 0 && index < products.size())) {
            return;
        }

        totalPrice -= products.get(index).getPrice();

        products.remove(index);
    }

    public int getProductCount() {
        return products.size();
    }

    public Product getProduct(int index) {
        if (!(index >= 0 && index < products.size())) {
            return null;
        }

        return products.get(index);
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
