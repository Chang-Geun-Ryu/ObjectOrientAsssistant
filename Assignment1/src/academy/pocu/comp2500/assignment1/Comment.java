package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;

public class Comment {
    private String text;
    private String author;
    private OffsetDateTime userId;
    private ArrayList<Comment> subcomments;
    private int upvote = 0;
    private int downvote = 0;


    public Comment(User user, String text) {
        this.text = text;
        this.author = user.getName();
        this.subcomments = new ArrayList<Comment>();
        this.userId = user.getUserId();
    }


    public String getText() {
        return this.text;
    }

    public String getAuthor() {
        return this.author;
    }

    public OffsetDateTime getUserId() {
        return this.userId;
    }

    public ArrayList<Comment> getSubcomments() {
        this.subcomments.sort((o1, o2) -> (o2.getUpvote() - o2.getDownvote()) - (o1.getUpvote() - o1.getDownvote()));
        return this.subcomments;
    }

    public int getUpvote() {
        return this.upvote;
    }

    public int getDownvote() {
        return this.downvote;
    }

    public void setText(User user, String text) {
        if (user.getName().equals(this.author)) {
            this.text = text;
        }
    }


    public void addSubcomment(Comment comment) {
        this.subcomments.add(comment);
    }

    public void addUpvote() {
        this.upvote++;
    }

    public void addDownvote() {
        this.downvote++;
    }
}
