package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;

public class Post {
    private String text;
    private String title;
    private String author;
    private ArrayList<String> tags;
    private OffsetDateTime postTime;
    private OffsetDateTime modifyTime;
    private ArrayList<Comment> comments;
    private ArrayList<ReactionType> reactionTypes;

    public Post(User user, String title, String text) {
        this.title = title;
        this.text = text;
        this.author = user.getName();
        this.tags = new ArrayList<String>();
        this.postTime = OffsetDateTime.now();
        this.modifyTime = OffsetDateTime.now();
        this.comments = new ArrayList<Comment>();
        this.reactionTypes = new ArrayList<ReactionType>();
    }


    public String getText() {
        return this.text;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public OffsetDateTime getPostTime() {
        return this.postTime;
    }

    public OffsetDateTime getModifyTime() {
        return this.modifyTime;
    }

    public ArrayList<Comment> getComments() {
        this.comments.sort((o1, o2) -> (o2.getUpvote() - o2.getDownvote()) - (o1.getUpvote() - o1.getDownvote()));
        return this.comments;
    }

    public ArrayList<ReactionType> getReactionTypes() {
        return this.reactionTypes;
    }

    public void setTitle(String title) {
        this.title = title;
        this.modifyTime = OffsetDateTime.now();
    }

    public void setText(String text) {
        this.text = text;
        this.modifyTime = OffsetDateTime.now();
    }


    public void addTag(String tag) {
        if (this.tags.contains(tag)) {
            return;
        }
        this.tags.add(tag);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void addReaction(ReactionType reactionType) {
        this.reactionTypes.add(reactionType);
    }

    public void removeReaction(ReactionType reactionType) {
        this.reactionTypes.remove(reactionType);
    }


}
