package academy.pocu.comp2500.assignment2;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ShoppingCart {
    private HashMap<String, Product> products;

    public ShoppingCart() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        String productId = UUID.randomUUID().toString();
        this.products.put(productId, product);
    }

    public boolean removeProduct(String productId) {
        if (this.products.containsKey(productId)) {
            this.products.remove(productId);
            return true;
        }
        return false;
    }

    public int getAllPrice() {
        int sumPrice = 0;
        for (Map.Entry<String, Product> element : this.products.entrySet()) {
            sumPrice += element.getValue().getPrice();
        }
        return sumPrice;
    }
}
