package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Comment {

    private String text;
    private ArrayList<Comment> subComments = new ArrayList<>();
    private int score = 0;

    public Comment(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void updateText(String text) {
        this.text = text;
    }

    public void addSubComment(Comment comment) {
        subComments.add(comment);
    }

    public int getScore() {
        return score;
    }

    public void upvote() {
        score += 1;
    }

    public void downvote() {
        score -= 1;
    }

    public List<Comment> getSubCommentsRecursive() {
        ArrayList<Comment> totalSubComments = new ArrayList<>();
        subComments.sort(Comparator.comparingInt(Comment::getScore));

        for (Comment subComment : subComments) {
            totalSubComments.add(subComment);
            totalSubComments.addAll(subComment.getSubCommentsRecursive());
        }

        return totalSubComments;
    }
}
