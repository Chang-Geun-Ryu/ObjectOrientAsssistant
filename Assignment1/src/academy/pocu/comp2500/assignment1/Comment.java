package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.HashSet;

public class Comment {
    private String authorName;
    private String body;
    private HashSet<String> up = new HashSet<>();
    private HashSet<String> down = new HashSet<>();
    private int vote;
    private int upvote;
    private int downvote;
    private ArrayList<Comment> subcomments;

    public Comment(User user, String body) {
        this.authorName = user.getAuthorName();
        this.body = body;
        this.subcomments = new ArrayList<Comment>();
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public String getBody() {
        return this.body;
    }

    public int getVote() {
        this.vote = (this.upvote - this.downvote);
        if (this.vote < 0) {
            this.vote = 0;
        }
        return this.vote;
    }

    public int getUpVote() {
//        return upvote;
        return this.up.size();
    }

    public int getDownVote() {
//        return downvote;
        return this.down.size();
    }

    public ArrayList<Comment> getSubcomments() {
        this.subcomments.sort((a, b) -> {
            if (b.getVote() > a.getVote()) {
                return 1;
            } else if (b.getVote() < a.getVote()) {
                return -1;
            } else {
                return 0;
            }
        });
        return this.subcomments;
    }

    public void updateComment(User user, String body) {          // 오류
        if (this.authorName.equals(user.getAuthorName())) {
            this.body = body;
        }
    }

    public void addUpvoteComment(String userId) {
        this.up.add(userId);
        this.upvote += 1;
    }      // 오류

    public void addDownvoteComment(String userId) {
        this.down.add(userId);
        this.downvote += 1;
    }     //오류

    public void addSubcomment(Comment comment) {
        this.subcomments.add(comment);
    }

    public void updateSubcomment(Comment comment, User user, String body) {
        comment.updateComment(user, body);
    }

//    public void upVoteSubcomment(Comment comment) {
//        comment.addUpvoteComment();
//    }

//    public void downVoteSubcomment(Comment comment) {
//        comment.addDownvoteComment();
//    }
}
