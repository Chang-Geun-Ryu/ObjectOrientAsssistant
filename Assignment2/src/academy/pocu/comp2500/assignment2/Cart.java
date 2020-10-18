package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> shoppingCart;

    public Cart() {
        shoppingCart = new ArrayList<>();
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void addCart(Product product) {
        if (product == null) {
            return;
        }

        if (!shoppingCart.contains(product)) {
            shoppingCart.add(product);
        }
    }

    public void removeCart(Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            total += shoppingCart.get(i).getPrice();
        }
        return total;
    }

//    public void print() {
//        for (int i = 0; i < products.size(); i++) {
//            Product p = products.get(i);
//            System.out.println(p.getDisplayName());
//            System.out.println("R:" + p.getColor().getR() + ", G: " + p.getColor().getG() + ", B:" + p.getColor().getB());
//            System.out.println("Shipping Option: " + p.getDelivery());
//            System.out.println("Price: " + p.getPrice());
//            System.out.println();
//        }
//    }
}
