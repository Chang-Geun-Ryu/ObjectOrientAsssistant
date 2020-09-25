package academy.pocu.comp2500.assignment1;

import java.awt.image.AreaAveragingScaleFilter;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Post {
    private ArrayList<String> tags;
    private String title;
    private String body;
    private ArrayList<Comment> comments;
    private User author;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;

    private int funCount = 0;
    private int sadCount = 0;
    private int loveCount = 0;
    private int angryCount = 0;
    private int greatCount = 0;
    private HashMap<User, ReactionType> reactionMap;

    public User getAuthor() {
        return author;
    }
    public ArrayList<Comment> getComments() {
        ArrayList<Comment> result = new ArrayList<>(comments);
        result.sort((o1, o2) -> {
            if (o1.getVoteCount() < o2.getVoteCount()) {
                return 1;
            } else {
                return -1;
            }
        });
        return result;
    }
    public ArrayList<String> getTags() {
        return tags;
    }
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
//        if (this.author != user) {
//            return;
//        }
//        if (body == null) {
//            return;
//        }
        this.body = body;
        modified();
    }
    public void setTitle(User user, String title) {
//        if (this.author != user) {
//            return;
//        }
//        if (title == null) {
//            return;
//        }
//        if (title.length() == 0) {
//            return;
//        }
        this.title = title;
        modified();
    }
    public String getTitle() {
        return title;
    }

    public OffsetDateTime getCreatedDateTime() {
        return createdDateTime;
    }
    public OffsetDateTime getModifiedDateTime() {
        return modifiedDateTime;
    }
    private void modified() {
        modifiedDateTime = OffsetDateTime.now();
    }


    private Post() {
        createdDateTime = OffsetDateTime.now();
        modifiedDateTime = OffsetDateTime.now();
        comments = new ArrayList<>();
        tags = new ArrayList<>();
        reactionMap = new HashMap<>();
    }

    public Post(User author, String title, String body) {
        this();
        this.author = author;
        this.title = title;
        this.body = body;
    }

    public void tagAdder(String tag) {
        if (tags.contains(tag)) {
            return;
        }
        if (tag == null) {
            return;
        }
        if (tag.length() == 0) {
            return;
        }
        tags.add(tag);
    }

    public void commentAdder(Comment comment) {
        if (comments.contains(comment)) {
            return;
        }
        if (comment == null) {
            return;
        }

        comments.add(comment);
    }


    public void reactionAdder(User user, ReactionType reactionType) {
        if (user == null) {
            return;
        }
        if (reactionMap.containsKey(user)) {
            if (reactionMap.get(user) == reactionType) {
                return;
            } else {

                switch (reactionMap.get(user)) {
                    case FUN:
                        funCount--;
                        break;
                    case SAD:
                        sadCount--;
                        break;
                    case LOVE:
                        loveCount--;
                        break;
                    case ANGRY:
                        angryCount--;
                        break;
                    case GREAT:
                        greatCount--;
                        break;
                }
                reactionMap.replace(user, reactionType);
            }
        } else {
            reactionMap.put(user, reactionType);
        }
        switch (reactionType) {
            case FUN:
                funCount++;
                break;
            case SAD:
                sadCount++;
                break;
            case LOVE:
                loveCount++;
                break;
            case ANGRY:
                angryCount++;
                break;
            case GREAT:
                greatCount++;
                break;
        }
    }

    public void reactionRemover(User user) {
        if (user == null) {
            return;
        }

        if (reactionMap.containsKey(user)) {
            switch (reactionMap.get(user)) {
                case FUN:
                    funCount--;
                    break;
                case SAD:
                    sadCount--;
                    break;
                case LOVE:
                    loveCount--;
                    break;
                case ANGRY:
                    angryCount--;
                    break;
                case GREAT:
                    greatCount--;
                    break;
            }
            reactionMap.remove(user);
        }
    }

    public int getReactionCount(ReactionType reactionType) {
        int result = 0;
        switch (reactionType) {
            case FUN:
                result = funCount;
                break;
            case SAD:
                result = sadCount;
                break;
            case LOVE:
                result = loveCount;
                break;
            case ANGRY:
                result = angryCount;
                break;
            case GREAT:
                result = greatCount;
                break;
        }
        return result;
    }

}
