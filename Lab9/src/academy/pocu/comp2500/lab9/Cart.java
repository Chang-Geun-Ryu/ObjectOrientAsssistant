package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.UUID;

public final class Cart {
    private ArrayList<Book> books = new ArrayList<>();

    public Book getBookOrNull(int index) {
        if (this.books.size() <= index) {
            return null;
        }

        return this.books.get(index);
    }

    public int getBookCount() {
        return this.books.size();
    }

    public void addBooks(ArrayList<Book> books) {
        if (books == null) {
            return;
        }

        for (Book b : books) {
            addBook(b);
        }
    }

    public void addBook(Book book) {
        if (book == null) {
            return;
        }

        this.books.add(book);
    }

    public boolean remove(int index) {
        if (this.books.size() <= index) {
            return false;
        }

        this.books.remove(index);

        return true;
    }

    public int getTotalPrice(IPriceable pricingModel) {
        return pricingModel.getTotalPrice(this.books);
    }
}