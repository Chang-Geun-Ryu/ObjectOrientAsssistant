package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;

public class Post {
    private String author;
    private String title;
    private String content;
    private ArrayList<Comment> comments = new ArrayList<>();
    private ArrayList<String> tags = new ArrayList<>();

    private OffsetDateTime modifiedDateTime;
    private OffsetDateTime createdDateTime;

    private ArrayList<String> greatUsers = new ArrayList<>();
    private ArrayList<String> sadUsers = new ArrayList<>();
    private ArrayList<String> angryUsers = new ArrayList<>();
    private ArrayList<String> funUsers = new ArrayList<>();
    private ArrayList<String> loveUsers = new ArrayList<>();


    public enum Reaction {
        GREAT,
        SAD,
        ANGRY,
        FUN,
        LOVE
    }

    public ArrayList<String> getGreatUsers() {
        return greatUsers;
    }

    public ArrayList<String> getAngryUsers() {
        return angryUsers;
    }

    public ArrayList<String> getFunUsers() {
        return funUsers;
    }

    public ArrayList<String> getLoveUsers() {
        return loveUsers;
    }

    public ArrayList<String> getSadUsers() {
        return sadUsers;
    }

    public Post(String author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = this.createdDateTime;
    }
    public Post(String author, String title, String content, ArrayList<String> tags) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = this.createdDateTime;
    }

    public String getAuthor() {
        return this.author;
    }
    public String getTitle() {
        return this.title;
    }
    public String getContent() {
        return this.content;
    }
    public ArrayList<Comment> getComments() {
        this.sortComments();
        return this.comments;
    }

    public OffsetDateTime getCreatedDateTime() {
        return this.createdDateTime;
    }
    public OffsetDateTime getModifiedDateTime() {
        return this.modifiedDateTime;
    }

    private void setTitle(String title) {
        this.title = title;
    }
    private void setContent(String title) {
        this.content = content;
    }

    public void addComment(String user, String text) {
        Comment comment = new Comment(user, text);
        this.comments.add(comment);
    }

    public void modifyTitle(String user, String title) {
        if (this.author.equals(user)) {
            this.setTitle(title);
            this.modifiedDateTime = OffsetDateTime.now();
        }
    }

    public void modifyContent(String user, String content) {
        if (this.author.equals(user)) {
            this.setContent(content);
            this.modifiedDateTime = OffsetDateTime.now();
        }
    }

    public void addTag(String tag) {
        for (String testTag : this.tags) {
            if (tag.equals(testTag)) {
                return;
            }
        }
        this.tags.add(tag);
    }
    public ArrayList<String> getTags() {
        return this.tags;
    }

    public boolean isModifiedAfter(Post post) {
        return this.getModifiedDateTime().isAfter(post.getModifiedDateTime());
    }
    public boolean isModifiedBefore(Post post) {
        return this.getModifiedDateTime().isBefore(post.getModifiedDateTime());
    }
    public boolean isCreatedAfter(Post post) {
        return this.getCreatedDateTime().isAfter(post.getCreatedDateTime());
    }
    public boolean isCreatedBefore(Post post) {
        return this.getCreatedDateTime().isBefore(post.getCreatedDateTime());
    }
    public int compareTitle(Post post) {
        return this.title.compareTo(post.title);
    }

    public void sortComments() {
        Comment tmpComment;
        int index;
        for (int i = 0; i < this.comments.size(); i++) {
            tmpComment = this.comments.get(i);
            index = i;
            for (int j = i + 1; j < this.comments.size(); j++) {
                if (tmpComment.getPreference() < this.comments.get(j).getPreference()) {
                    tmpComment = this.comments.get(j);
                    index = j;
                }
            }
            if (i != index) {
                this.comments.set(index, this.comments.get(i));
                this.comments.set(i, tmpComment);
            }
        }
    }

//    public void sortCommentsUpward(Comment comment) {
//        Comment tmpCommnet;
//        int index = this.comments.indexOf(comment);
//        for (int i = index - 1; i >= 0; i--) {
//            if (this.comments.get(i).getPreference() < this.comments.get(index).getPreference()) {
//                tmpCommnet = this.comments.get(index);
//
//                this.comments.set(index, this.comments.get(i));
//
//                index = i;
//                this.comments.set(index, tmpCommnet);
//            }
//        }
//    }
//    public void sortCommentsDownward(Comment comment) {
//        Comment tmpComment;
//        int index = this.comments.indexOf(comment);
//        int tmp;
//        for (int i = index; i < this.comments.size(); i++) {
//            if (this.comments.get(i).getPreference() > this.comments.get(index).getPreference()) {
//                tmpComment = this.comments.get(index);
//
//                this.comments.set(index, this.comments.get(i));
//
//                index = i;
//                this.comments.set(index, tmpComment);
//            }
//        }
//    }
//    public void upvoteComment(String user, Comment comment) {
//        comment.addUpvote(user);
//        sortCommentsUpward(comment);
//    }
//    public void downvoteComment(String user, Comment comment) {
//        comment.addDownvote(user);
//        sortCommentsDownward(comment);
//    }

    public void addReaction(String user, Reaction reaction) {
        switch (reaction) {
            case GREAT:
                this.greatUsers.add(user);
                break;
            case FUN:
                this.funUsers.add(user);
                break;
            case SAD:
                this.sadUsers.add(user);
                break;
            case ANGRY:
                this.angryUsers.add(user);
                break;
            case LOVE:
                this.loveUsers.add(user);
                break;
        }
    }

    public void removeReaction(String user, Reaction reaction) {
        switch (reaction) {
            case GREAT:
                this.greatUsers.remove(user);
                break;
            case FUN:
                this.funUsers.remove(user);
                break;
            case SAD:
                this.sadUsers.remove(user);
                break;
            case ANGRY:
                this.angryUsers.remove(user);
                break;
            case LOVE:
                this.loveUsers.remove(user);
                break;
        }
    }


//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//
//        for (Comment comment : this.getComments()) {
//            for (int tab = 0; tab < comment.getTab(); tab++) {
//                sb.append(String.format("   "));
//            }
//            sb.append(String.format("%s%s", comment.getText(), System.lineSeparator()));
//            for (Comment item : comment.getSubcomments()) {
//                sb.append(String.format("%s", item.toString()));
//            }
//        }
//
//
//        return sb.toString();
//    }


}
