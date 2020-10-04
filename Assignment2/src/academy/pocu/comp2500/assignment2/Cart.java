package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> list;

    public Cart() {
        this.list = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.list.add(product);
    }

    public void removeProduct(Product product) {
        this.list.remove(product);
    }

    public ArrayList<Product> getAllProducts() {
        return this.list;
    }

    public Product getProduct(int index) {
        return this.list.get(index);
    }

    public int getTotalPrice() {
        return this.list
                .stream()
                .map(e -> e.getPrice())
                .reduce(0, (total, e) -> total + e);

    }


}
