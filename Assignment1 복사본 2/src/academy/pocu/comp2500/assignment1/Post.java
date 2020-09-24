package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;

public class Post {
    private String authorName;
    private String title;
    private String body;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    private ArrayList<String> tags;
    private ArrayList<Reaction> reactions;
    private ArrayList<Comment> comments;

    public Post(User user, String title, String body) {
        this.authorName = user.getAuthorName();
        this.title = title;
        this.body = body;
        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = OffsetDateTime.now();
        this.tags = new ArrayList<String>();
        this.reactions = new ArrayList<Reaction>();
        this.comments = new ArrayList<Comment>();
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public OffsetDateTime getCreatedDateTime() {
        return this.createdDateTime;
    }

    public OffsetDateTime getModifiedDateTime() {
        return this.modifiedDateTime;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public ArrayList<Reaction> getReactions() {
        return this.reactions;
    }

    public ArrayList<Comment> getComments() {
        this.comments.sort((a, b) -> {
            if (b.getVote() > a.getVote()) {
                return 1;
            } else if (b.getVote() < a.getVote()) {
                return -1;
            } else {
                return 0;
            }
        });
        return this.comments;
    }

    public void setTitle(String title) {
        this.title = title;
        this.modifiedDateTime = OffsetDateTime.now();
    }

    public void setBody(String body) {
        this.body = body;
        this.modifiedDateTime = OffsetDateTime.now();
    }

    public void addTag(String tag) {
        boolean duplicateChecker = false;
        for (String t : this.tags) {
            if (tag.equals(t)) {
                duplicateChecker = true;
            }
        }
        if (!duplicateChecker) {
            this.tags.add(tag);
        }
    }

    public void addReaction(Reaction reactionType) {
        this.reactions.add(reactionType);
    }

    public void removeReaction(Reaction reactionType) {
        this.reactions.remove(reactionType);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }
}
