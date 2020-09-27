package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Comment {
    private final int commentId;
    private final String author;
    private final OffsetDateTime createdDateTime;
    private final ArrayList<Comment> subcomments;
    private final ArrayList<String> upvote;
    private final ArrayList<String> downvote;
    private OffsetDateTime modifiedDateTime;
    private String content;

    public Comment(String author, String content) {
        this.commentId = this.hashCode();
        this.author = author;
        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = OffsetDateTime.now();
        this.content = content;
        this.subcomments = new ArrayList<>();
        this.upvote = new ArrayList<>();
        this.downvote = new ArrayList<>();
    }

//    public int getCommentId() {
//        return this.commentId;
//    }

    public String getAuthor() {
        return author;
    }

    public OffsetDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public OffsetDateTime getModifiedDateTime() {
        return modifiedDateTime;
    }

    public String getContent() {
        return this.content;
    }

    public ArrayList<Comment> getSubcomments() {
        ArrayList<Comment> sortComment = subcomments;

        Collections.sort(sortComment, (lhs, rhs) -> Integer.compare(rhs.getDifferenceVoteCount(), lhs.getDifferenceVoteCount()));

        return sortComment;
//        Comment[] commentArray = subcomments.values().toArray(new Comment[0]);
//        Comment tempComment;
//        int max = 0;
//        for (int i = 0; i < commentArray.length - 1; i++) {
//            max = i;
//            for (int j = i + 1; j < commentArray.length; j++) {
//                if (commentArray[j].getDifferenceVoteCount() > commentArray[max].getDifferenceVoteCount()) {
//                    max = j;
//                }
//            }
//            tempComment = commentArray[i];
//            commentArray[i] = commentArray[max];
//            commentArray[max] = tempComment;
//        }
//
//        return new ArrayList<>(Arrays.asList(commentArray));
    }

    public int getUpvote() {
        return this.upvote.size();
    }

    public int getDownvote() {
        return this.downvote.size();
    }

    public int getDifferenceVoteCount() {
        return this.upvote.size() - this.downvote.size();
    }

    public void updateModifiedDateTime() {
        setModifiedDateTime(OffsetDateTime.now());
    }

    public void upvote(String author) {
        if (!upvote.contains(author)) {
            this.upvote.add(author);
        }
    }

    public void downvote(String author) {
        if (!downvote.contains(author)) {
            this.downvote.add(author);
        }
    }

    public void addSubcomment(Comment comment) {
//        int subcommentId = comment.getCommentId();
//        subcomments.put(subcommentId, comment);
        subcomments.add(comment);
    }

    public void updateComment(String author, String content) {
        if (this.author.equals(author)) {
            setContent(content);
            updateModifiedDateTime();
        }
    }


    private void setContent(String content) {
        this.content = content;
    }

    private void setModifiedDateTime(OffsetDateTime modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }
}
