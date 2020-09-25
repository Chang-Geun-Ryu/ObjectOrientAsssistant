package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Comment {
    private User user;
    private String body;
    private Map<User, Voter> voters;
    private ArrayList<Comment> subcomment;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    public OffsetDateTime getCreatedDateTime() {
        return createdDateTime;
    }
    public OffsetDateTime getModifiedDateTime() {
        return modifiedDateTime;
    }
    private void modified() {
        modifiedDateTime = OffsetDateTime.now();
    }

    public void setBody(User user, String body) {
        if (this.user.getFullName().contentEquals(user.getFullName()) == false) {
            return;
        }
//        if (body == null) {
//            return;
//        }
        this.body = body;
        modified();
    }

    public ArrayList<Comment> getSubcomment() {
        return subcomment;
    }

    private Comment() {
        super();
        createdDateTime = OffsetDateTime.now();
        modifiedDateTime = OffsetDateTime.now();
        subcomment = new ArrayList<Comment>();
        voters = new HashMap<>();
    }

    public Comment(User user, String body) {
        this();
        this.user = user;
        this.setBody(user, body);
    }

    public void subcommentAdder(Comment comment) {
        subcomment.add(comment);
    }

    public int getVoteCount() {
        int count = 0;
        for (Voter v : voters.values()) {
            switch (v) {
                case UP:
                    count++;
                    break;
                case DOWN:
                    count--;
                    break;
                default:
                    break;
            }
        }
        return count;
    }

    public void commentUpvoter(User user) {
        if (voters.containsKey(user)) {
            voters.replace(user, Voter.UP);
        } else {
            voters.put(user, Voter.UP);
        }
    }
    public void commentDownvoter(User user) {
        if (voters.containsKey(user)) {
            voters.replace(user, Voter.DOWN);
        } else {
            voters.put(user, Voter.DOWN);
        }
    }
}
