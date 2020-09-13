package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;

public class User {
    private OffsetDateTime userId;
    private String name;

    public User(String name) {
        this.name = name;
        this.userId = OffsetDateTime.now();
    }

    public OffsetDateTime getUserId() {
        return this.userId;
    }

    public String getName() {
        return this.name;
    }

}
