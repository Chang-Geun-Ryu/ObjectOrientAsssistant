package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Comparator;

public class Comment {
    private String commentId;
    private String text;
    private ArrayList<Comment> subComments;
    private int upVote;
    private int downVote;

    public Comment(String commentId, String text) {
        this.text = text;
        this.commentId = commentId;
        subComments = new ArrayList<>();
    }

    public void renameComment(String commentId, String text) {
        if (this.commentId.equals(commentId)) {
            this.text = text;
        }
    }

    public void addSubComment(String subCommentId, String text) {
        subComments.add(new Comment(subCommentId, text));
    }

    public void addUpVote() {
        this.upVote++;
    }

    public void addDownVote() {
        this.downVote++;
    }

    public ArrayList<Comment> getSubComments() {
        ArrayList<Comment> comments = new ArrayList<>(this.subComments);

        comments.sort((Comparator.comparingInt(o -> (o.getUpVote() - o.getDownVote()))));
        return comments;
    }

    public int getUpVote() {
        return upVote;
    }

    public int getDownVote() {
        return downVote;
    }
}
