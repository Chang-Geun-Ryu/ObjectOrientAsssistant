package academy.pocu.comp2500.assignment1;


import java.util.Collections;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Content {
    private String title = "";
    private String body = "";
    private String authorId;
    private OffsetDateTime createDate;
    private OffsetDateTime modifyDate;
    private HashSet<String> tag;
    private ArrayList<Comment> comments;
    private HashMap<Type, ArrayList<String>> reactions;

    public enum Type {
        GRATE,
        SAD,
        ANGRY,
        FUN,
        LOVE
    }

    public Content(String title, String body, String authorId) {
        this.createDate = OffsetDateTime.now();
        this.modifyDate = this.createDate;
        this.authorId = authorId;
        this.title = title;
        this.body = body;

        this.tag = new HashSet<String>();
        this.comments = new ArrayList<>();
        this.reactions = new HashMap<Type, ArrayList<String>>();
        this.reactions.put(Type.ANGRY, new ArrayList<>());
        this.reactions.put(Type.FUN, new ArrayList<>());
        this.reactions.put(Type.GRATE, new ArrayList<>());
        this.reactions.put(Type.LOVE, new ArrayList<>());
        this.reactions.put(Type.SAD, new ArrayList<>());
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final ArrayList<String> getTag() {
        return new ArrayList<String>(this.tag);
    }

    public final OffsetDateTime getPostTime() {
        return this.createDate;
    }

    public final OffsetDateTime getModifyTime() {
        return this.modifyDate;
    }

    public final ArrayList<Comment> getComments() {
        return this.comments;
    }

    public final HashMap<Type, ArrayList<String>> getReactions() {
        return this.reactions;
    }

    public final void modifyPostTitle(String title) {
        this.modifyDate = OffsetDateTime.now();
        this.title = title;
        System.out.println(this.modifyDate);
    }

    public final void modifyPostBody(String body) {
        this.modifyDate = OffsetDateTime.now();
        this.body = body;
        System.out.println(this.modifyDate);
    }

    public final void addPostTag(String tag) {
        this.tag.add(tag);
    }

    public final void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public final void setReaction(Type type, String userId) {
        if (this.reactions.containsKey(type)) {
            this.reactions.get(type).add(userId);
        } else {
            ArrayList<String> array = new ArrayList<>();
            array.add(userId);
            this.reactions.put(type, array);
        }
    }

    public final void removeReaction(Type type, String userId) {
        if (this.reactions.get(type).contains(userId)) {
            this.reactions.get(type).remove(userId);
        }
    }

    public final ArrayList<Comment> getSortedComments() {
        ArrayList<Comment> sortComment = getComments();
        Collections.sort(sortComment, (lhs, rhs) -> Integer.compare(rhs.getScore(), lhs.getScore()));
        return sortComment;
    }

}
