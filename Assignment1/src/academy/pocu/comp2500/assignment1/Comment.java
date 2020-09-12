package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;

public class Comment {
    private String sComment;
    private String userId;
    private ArrayList<String> likes;
    private ArrayList<String> hates;
    private final ArrayList<Comment> subcomment;

    public Comment(String comment, String userId) {
        this.likes = new ArrayList<>();
        this.hates = new ArrayList<>();
        this.sComment = comment;
        this.userId = userId;
        this.subcomment = new ArrayList<>();
    }

    public final void addLike(String userId) {
        if (this.likes.contains(userId) == false) {
            this.likes.add(userId);
        }
    }

    public final void addHate(String userId) {
        if (this.hates.contains(userId) == false) {
            this.hates.add(userId);
        }
    }

    public final int getScore() {
        return this.likes.size() - this.hates.size();
    }

    public final void setComment(String comment, String userId) {
        if (userId == this.userId) {
            this.sComment = comment;
        }
    }

    public final void addSubcomment(Comment comment) {
        this.subcomment.add(comment);
    }

    private final ArrayList<Comment> getSubcomment() {
        return this.subcomment;
    }

    public final ArrayList<Comment> getSortedSubcomments() {
        ArrayList<Comment> sortComment = getSubcomment();

        Collections.sort(sortComment, (lhs, rhs) -> Integer.compare(rhs.getScore(), lhs.getScore()));

        return sortComment;
    }

    public final String getComment() {
        return sComment;
    }
}
