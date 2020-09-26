package academy.pocu.comp2500.assignment1;

import java.awt.image.AreaAveragingScaleFilter;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class Post {
    private HashSet<String> tags;
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
    private HashMap<String, ReactionType> reactionMap;
    private ArrayList<ReactionType> reactions;
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
    public HashSet<String> getTags() {
        return tags;
    }
    public String getBody() {
        return body;
    }

    public void setTitle(User user, String title) {
        if (!this.author.getNickname().equals(user.getNickname())) {
            return;
        }
        if (title == null) {
            return;
        }
        this.title = title;
        modified();
    }

    public void setBody(User user, String body) {
        if (!this.author.getNickname().equals(user.getNickname())) {
            return;
        }
        if (body == null) {
            return;
        }
        this.body = body;
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
        tags = new HashSet<>();
        reactionMap = new HashMap<>();
    }

    public Post(User author, String title, String body) {
        this();
        this.author = author;
        this.title = title;
        this.body = body;
    }

    public void tagAdder(User user, String tag) {
        if (!user.getNickname().equals(this.author.getNickname())) {
            return;
        }
        if (tag == null) {
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


    public void reactionAdder(ReactionType reactionType) {
        reactions.add(reactionType);
//        if (user == null) {
//            return;
//        }
//        if (user.getNickname().equals(author.getNickname())) {
//            return;
//        }
//        String name = user.getNickname();
//        if (reactionMap.containsKey(name)) {
//            if (reactionMap.get(name).equals(reactionType)) {
//                return;
//            } else {
//
//                switch (reactionMap.get(name)) {
//                    case FUN:
//                        funCount--;
//                        break;
//                    case SAD:
//                        sadCount--;
//                        break;
//                    case LOVE:
//                        loveCount--;
//                        break;
//                    case ANGRY:
//                        angryCount--;
//                        break;
//                    case GREAT:
//                        greatCount--;
//                        break;
//                }
//                reactionMap.replace(name, reactionType);
//            }
//        } else {
//            reactionMap.put(name, reactionType);
//        }
//        switch (reactionType) {
//            case FUN:
//                funCount++;
//                break;
//            case SAD:
//                sadCount++;
//                break;
//            case LOVE:
//                loveCount++;
//                break;
//            case ANGRY:
//                angryCount++;
//                break;
//            case GREAT:
//                greatCount++;
//                break;
//        }
    }

    public void reactionRemover(ReactionType reactionType) {
        reactions.remove(reactionType);
//        if (user == null) {
//            return;
//        }
//        if (user.getNickname().equals(author.getNickname())) {
//            return;
//        }
//        String name = user.getNickname();
//
//        if (reactionMap.containsKey(name)) {
//            switch (reactionMap.get(name)) {
//                case FUN:
//                    funCount--;
//                    break;
//                case SAD:
//                    sadCount--;
//                    break;
//                case LOVE:
//                    loveCount--;
//                    break;
//                case ANGRY:
//                    angryCount--;
//                    break;
//                case GREAT:
//                    greatCount--;
//                    break;
//            }
//            reactionMap.remove(name);
//        }
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


    HashSet<String> getAllTags() {
        HashSet<String> temp = new HashSet<String>(tags);
        temp.add(author.getNickname());
        return temp;
    }
}
