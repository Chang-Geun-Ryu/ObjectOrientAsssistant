package academy.pocu.comp2500.assignment1;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Post {

    private String title;
    private String body;
    private User user;
    private final OffsetDateTime createTime;
    private OffsetDateTime modificationTime;
    private final HashSet<String> tags = new HashSet<>();
    private final ArrayList<Comment> comments = new ArrayList<>();
    private final ArrayList<Reaction> reactions = new ArrayList<>();

    public Post(String title, String body, User user, List<String> tags) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.createTime = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.ofHours(8));
        this.modificationTime = createTime;
        this.tags.addAll(tags);
    }

    public Post(String title, String body, User user) {
        this(title, body, user, List.of());
    }

    public OffsetDateTime getCreateTime() {
        return createTime;
    }

    public OffsetDateTime getModificationTime() {
        return modificationTime;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }

    public String getBody() {
        return body;
    }

    public ArrayList<Reaction> getReactions() {
        return reactions;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public List<Comment> getComments() {
        comments.sort((c1, c2) -> c2.getScore() - c1.getScore());
        return comments;
    }

    public void updateTitle(String title) {
        this.title = title;
        this.modificationTime = OffsetDateTime.now();
    }

    public void updateBody(String body) {
        this.body = body;
        this.modificationTime = OffsetDateTime.now();

    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public boolean containTags(List<String> tags) {
        for (String tag : tags) {
            if (this.tags.contains(tag)) {
                return true;
            }
        }

        return false;
    }

    public void addReaction(Reaction reaction) {
        this.reactions.add(reaction);
    }

    public void removeReaction(int reactionId) {
        this.reactions.remove(reactionId);
    }

    public void setWriter(User user) {
        this.user = user;
    }
}
