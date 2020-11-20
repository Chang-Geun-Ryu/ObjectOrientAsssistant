package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.HashMap;

public class DecadeMadness implements IPriceable {
    @Override
    public int getTotalPrice(ArrayList<Book> collections) {
        if (collections == null || collections.size() == 0) {
            return 0;
        }

        double sum = 0.d;

        HashMap<Integer, ArrayList<Integer>> decadeMap = new HashMap<>();
        for (Book book : collections) {
            int decade = book.getPublishedYear() / 10;

            if (decadeMap.containsKey(decade)) {
                decadeMap.get(decade).add(book.getPrice());
            } else {
                ArrayList<Integer> price = new ArrayList<>();
                price.add(book.getPrice());
                decadeMap.put(decade, price);
            }
        }

        for (ArrayList<Integer> prices : decadeMap.values()) {
            if (prices.size() == 1) {
                sum += (double) prices.get(0);
            } else if (prices.size() > 1) {
                sum += (double) prices.stream().reduce(0, (total, velue) -> total + velue) * 0.8;
            } else {
                assert false : "DecadeMadness price calc fail";
            }
        }

        return (int) sum;
    }
}
