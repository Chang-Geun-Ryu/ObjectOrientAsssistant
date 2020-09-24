package academy.pocu.comp2500.assignment1;

public class JeAuthor {
    private String name;
    private int userId;

    public JeAuthor(String name) {
        this.name = name;
        userId = (name + this).hashCode();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return userId;
    }
}
