package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ProductBasket {
    private ArrayList<BaseProduct> productBoxes = new ArrayList<>();

    public ProductBasket() {
    }

    public void addProduct(BaseProduct product) {
        productBoxes.add(product);
    }

    public void removeProduct(BaseProduct product) {
        productBoxes.remove(product);
    }

    public void setShippintMethod(BaseProduct product, EShippingMethod shippingMethod) {
        for (BaseProduct productBox : productBoxes) {
            if (product == productBox) {
                productBox.setShippingMethod(shippingMethod);
            }
        }
    }

    public int getTotalPrice() {
        int price = 0;
        for (BaseProduct item : productBoxes) {
            price += item.getPrice();
        }
        return price;
    }
}
