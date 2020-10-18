package academy.pocu.comp2500.assignment2;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private HashMap<String, Product> products;

    public ShoppingCart() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        this.products.put(product.getProductId(), product);
    }

    public boolean removeProduct(Product product) {
        if (this.products.containsKey(product.getProductId())) {
            this.products.remove(product.getProductId());
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

    public HashMap<String, Product> getProducts() {
        return products;
    }
}
