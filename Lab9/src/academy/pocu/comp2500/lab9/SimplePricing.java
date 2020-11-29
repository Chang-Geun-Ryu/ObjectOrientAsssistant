package academy.pocu.comp2500.lab9;

import java.util.ArrayList;

public class SimplePricing implements IPriceable {

    @Override
    public int getTotalPrice(ArrayList<Book> collections) {
        if (collections == null) {
            return 0;
        }

        int sum = 0;

        for (Book book : collections) {
            sum += book.getPrice();
        }

        return sum;
    }
}
