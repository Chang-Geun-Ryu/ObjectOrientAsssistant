package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Comment {
    private String userId;
    private ArrayList<Comment> subcomments;
    private String text;
    private ArrayList<String> upvotes;
    private ArrayList<String> downvotes;

    public Comment(String userId, String text) {
        this.userId = userId;
        this.text = text;
        this.subcomments = new ArrayList<Comment>();
        this.upvotes = new ArrayList<String>();
        this.downvotes = new ArrayList<String>();
    }

    public void addSubcomment(Comment comment) {
        this.subcomments.add(comment);
    }

    public void setComment(String userId, String text) {
        if (this.userId == userId) {
            this.text = text;
        }
    }

    public ArrayList<Comment> getSubcomments() {
        return this.subcomments;
    }

    public void addUpvote(String userId) {
        ArrayList<String> upvotes = this.upvotes;

        for (int i = 0; i < upvotes.size(); ++i) {
            if (userId.equals(upvotes.get(i))) {
                return;
            }
        }
        this.upvotes.add(userId);
    }

    public void addDownvote(String userId) {
        ArrayList<String> downvotes = this.downvotes;

        for (int i = 0; i < downvotes.size(); ++i) {
            if (userId.equals(downvotes.get(i))) {
                return;
            }
        }
        this.downvotes.add(userId);
    }
}
