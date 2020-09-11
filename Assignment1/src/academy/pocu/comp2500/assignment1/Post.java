package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Post {
    private String authorId;
    private String title;
    private String text;
    private OffsetDateTime createdDataTime;
    private OffsetDateTime modifiedDataTime;
    private HashSet<String> tags;
    private ArrayList<Comment> comments;

    private int[] reactionsCount;

    public Post(String authorId, String title, String text) {
        this.authorId = authorId;
        this.title = title;
        this.text = text;
        this.createdDataTime = OffsetDateTime.now();
        this.modifiedDataTime = OffsetDateTime.now();
        this.tags = new HashSet<>();
        this.comments = new ArrayList<>();
        this.reactionsCount = new int[5];
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getTitle() {
        return title;
    }

    public HashSet<String> getTags() {
        return tags;
    }

    public OffsetDateTime getCreatedDataTime() {
        return createdDataTime;
    }

    public OffsetDateTime getModifiedDataTime() {
        return modifiedDataTime;
    }

    public ArrayList<Comment> getComments() {
        this.comments.sort((Comparator.comparingInt(o -> (o.getUpVote() - o.getDownVote()))));
        return comments;
    }

    public void AddComment(String userId, String text) {
        comments.add(new Comment(userId, text));
    }

    public void AddOrSubReaction(ReactionType reactionType, ReactionAddOrSub addOrSub) {
        int vote = 0;
        switch (addOrSub) {
            case ADD: {
                vote = 1;
                break;
            }
            case SUB: {
                vote = -1;
                break;
            }
            default: {
                assert (false) : "Enum Error";
            }
        }

        reactionsCount[reactionType.ordinal()] += vote;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public void setTitle(String title) {
        this.title = title;
        modifiedDataTime = OffsetDateTime.now();
    }

    public void setText(String text) {
        this.text = text;
        modifiedDataTime = OffsetDateTime.now();
    }
}
