package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        for (int i = 0; i < products.size(); ++i) {
            if (products.get(i).isEquals(product)) {
                products.remove(i);
                return;
            }
        }
    }

    public int getTotalPrice() {
        int price = 0;

        if (products.size() == 0) {
            return price;
        }
        for (Product product : products) {
            price += product.price;
        }
        return price;
    }
}
