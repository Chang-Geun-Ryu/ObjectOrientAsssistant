package academy.pocu.comp2500.assignment1;

public class User {
    private String nickname;
    private String firstName;
    private String lastName;
    private String fullName;
    private User() {

    }
    public User(String nickname, String firstName, String lastName) {
        this.nickname = nickname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = lastName + firstName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getNickname() {
        return nickname;
    }
}
