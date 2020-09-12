package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;

public class Comment {
    private OffsetDateTime commentId;
    private ArrayList<Comment> subcommentList;
    private String author;
    private String content;
    private int upvote = 0;
    private int downvote = 0;

    //생성자 매개변수로 post 없애고 포스트에서 addComment 에서 코멘트 아이디 설정해주는 걸로함
    public Comment(User author, String content) {
        //commentId = post.getPostId();
        this.author = author.getNickname();
        this.content = content;
        subcommentList = new ArrayList<Comment>();
    }

    public ArrayList<Comment> getSubCommentList() {
        subcommentList.sort((subcomment1, subcomment2) -> {
            if ((subcomment1.getUpvote() - subcomment1.getDownvote()) - (subcomment2.getUpvote() - subcomment2.getDownvote()) > 0) {
                return -1;
            } else if ((subcomment1.getUpvote() - subcomment1.getDownvote()) - (subcomment2.getUpvote() - subcomment2.getDownvote()) < 0) {
                return 1;
            }
            return 0;
        });
        return subcommentList;
    }

    public void upVote() {
        this.upvote++;
    }

    public void downVote() {
        this.downvote++;
    }

    public int getUpvote() {
        return upvote;
    }

    public int getDownvote() {
        return downvote;
    }

    public void updateComment(User author, String content) {
        if (author.getUserId().compareTo(commentId) == 0) {
            this.content = content;
        } else {
            System.out.println("Author only update comment.");
        }
    }

    public void addSubcomment(Comment comment) {
        comment.setCommentId(commentId);
        this.subcommentList.add(comment);
    }

    public OffsetDateTime getCommentId() {
        return commentId;
    }

    public void setCommentId(OffsetDateTime commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public ArrayList<Comment> getSubcommentList() {
        subcommentList.sort((subcomment1, subcomment2) -> {
            if ((subcomment1.getUpvote() - subcomment1.getDownvote()) - (subcomment2.getUpvote() - subcomment2.getDownvote()) > 0) {
                return -1;
            } else if ((subcomment1.getUpvote() - subcomment1.getDownvote()) - (subcomment2.getUpvote() - subcomment2.getDownvote()) < 0) {
                return 1;
            }
            return 0;
        });
        return subcommentList;
    }
}
