package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;

public class User {
    private String nickname;
    private OffsetDateTime userId;

    public User(String name) {
        this.nickname = name;
        this.userId = OffsetDateTime.now();
    }

    public String getNickname() {
        return nickname;
    }

    public OffsetDateTime getUserId() {
        return userId;
    }
}