package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Comment {
    private String text;
    private String user;
    private ArrayList<Comment> subcomments;
    private int tab;
    private ArrayList<String> upvotes;
    private ArrayList<String> downvotes;
    private int preference;

    public Comment(String user, String text) {
        this.user = user;
        this.text = text;
        subcomments = new ArrayList<>();
        upvotes = new ArrayList<>();
        downvotes = new ArrayList<>();
        preference = 0;
    }

    public String getText() {
        return this.text;
    }
    public ArrayList<Comment> getSubcomments() {
        return this.subcomments;
    }
    public String getUser() {
        return this.user;
    }
    public int getTab() {
        return this.tab;
    }
    public int getPreference() {
        return this.preference;
    }


    public void setText(String text) {
        this.text = text;
    }

    private void setSubcommentsTab(int previousTab) {
        this.tab = previousTab + 1;
        for (Comment comment : this.subcomments) {
            comment.setSubcommentsTab(this.getTab());
            comment.setSubcommentsTab(this.getTab());
        }
    }

    public void modifySubcomment(int count, String text) {
        this.subcomments.get(count).setText(text);
    }

    public void addSubcomment(String user, String text) {
        Comment comment = new Comment(user, text);

        comment.setSubcommentsTab(this.getTab());
        this.subcomments.add(comment);
    }


    public void removeSubcomment(String user, int count) {
        Comment comment = this.subcomments.get(count);
        if (comment.getUser() == user) {
            if (!comment.subcomments.isEmpty()) {
                comment.setText("This comment is deleted");
            } else {
                this.subcomments.remove(count);
            }
        }
    }

    public void addUpvote(String user) {
        for (String voter : this.upvotes) {
            if (voter.equals(user)) {
                System.out.println("You upvote twice");
                return;
            }
        }
        this.upvotes.add(user);
        this.preference += 1;
    }

    public void addDownvote(String user) {
        for (String voter : this.downvotes) {
            if (voter.equals(user)) {
                System.out.println("You downvote twice");
                return;
            }
        }
        this.downvotes.add(user);
        this.preference -= 1;
    }


    private void sortSubcommentsUpward(Comment comment) {
        Comment tmpComment;
        int index = this.subcomments.indexOf(comment);
        for (int i = index - 1; i >= 0; i--) {
            if (this.subcomments.get(i).getPreference() < this.subcomments.get(index).getPreference()) {
                tmpComment = this.subcomments.get(index);

                this.subcomments.set(index, this.subcomments.get(i));

                index = i;
                this.subcomments.set(index, tmpComment);
            }
        }
    }
    private void sortSubcommentsDownward(Comment comment) {
        Comment tmpComment;
        int index = this.subcomments.indexOf(comment);
        int tmp;
        for (int i = index; i < this.subcomments.size(); i++) {
            if (this.subcomments.get(i).getPreference() > this.subcomments.get(index).getPreference()) {
                tmpComment = this.subcomments.get(index);

                this.subcomments.set(index, this.subcomments.get(i));

                index = i;
                this.subcomments.set(index, tmpComment);
            }
        }
    }

    public void upvoteSubcomment(String user, Comment comment) {
        comment.addUpvote(user);
        this.sortSubcommentsUpward(comment);
    }

    public void downvoteSubcomment(String user, Comment comment) {
        comment.addDownvote(user);
        this.sortSubcommentsDownward(comment);
    }



//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//
//        for (int tab = 0; tab < this.tab; tab++) {
//            sb.append(String.format("   "));
//        }
//        sb.append(String.format("%s%s", this.text, System.lineSeparator()));
//        for (Comment item : this.subcomments) {
//            sb.append(String.format("%s", item.toString()));
//        }
//
//        return sb.toString();
//    }
}
