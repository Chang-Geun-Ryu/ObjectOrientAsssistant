package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.time.OffsetDateTime;

public class Article {
    private String userId;
    private String title;
    private String content;
    private ArrayList<String> tags;
    private ArrayList<Comment> comments;
    private ArrayList<Reaction> reactions;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;

    public Article(String userId, String title, String content) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.tags = new ArrayList<String>();
        this.comments = new ArrayList<Comment>();
        this.reactions = new ArrayList<Reaction>();
        this.createdAt = OffsetDateTime.now();
        this.modifiedAt = OffsetDateTime.now();
    }

    public void setTitle(String userId, String title) {
        if (this.userId.equals(userId)) {
            this.title = title;
            this.modifiedAt = OffsetDateTime.now();
        }
    }

    public void setContent(String userId, String content) {
        if (this.userId.equals(userId)) {
            this.content = content;
            this.modifiedAt = OffsetDateTime.now();
        }
    }

    public void addTag(String userId, String tag) {
        if (this.userId.equals(userId)) {
            ArrayList<String> tags = this.tags;

            for (int i = 0; i < tags.size(); ++i) {
                if (tag.equals(tags.get(i))) {
                    return;
                }
            }
            this.tags.add(tag);
//            this.modifiedAt = OffsetDateTime.now();
        }
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public void createComment(Comment comment) {
        this.comments.add(comment);
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public ArrayList<Comment> getComments() {
        return this.comments;
    }

    public ArrayList<Reaction> getReactions() {
        return this.reactions;
    }

    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    public OffsetDateTime getModifiedAt() {
        return this.modifiedAt;
    }

    public void addReaction(String userId, Reaction.ReactionType reactionType) {
        Reaction newReaction = new Reaction(userId, reactionType);
        this.reactions.add(newReaction);
    }

    public void removeReaction(String userId, Reaction.ReactionType reactionType) {
        Reaction reactionToRemove;
        for (int i = 0; i < this.reactions.size(); ++i) {
            Reaction reaction = this.reactions.get(i);
            if (reaction.getUserId().equals(userId)) {
                if (reaction.getReactionType() == reactionType) {
                    this.reactions.remove(i);
                    break;
                }
            }
        }
    }

    public String getUserId() {
        return this.userId;
    }
}
