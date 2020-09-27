package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Article {
    private final int articleId;
    private final String author;
    private String title;
    private String content;
    private final OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    private final ArrayList<String> tags;
    private final HashMap<Integer, Comment> comments;
    private final HashMap<Reaction, Integer> reactions;

    public Article(String author, String title, String content) {
        this.articleId = hashCode();
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = OffsetDateTime.now();
        this.tags = new ArrayList<>();
        this.comments = new HashMap<>();
        this.reactions = new HashMap<>();
        this.reactions.put(Reaction.GREAT, 0);
        this.reactions.put(Reaction.SAD, 0);
        this.reactions.put(Reaction.ANGRY, 0);
        this.reactions.put(Reaction.FUN, 0);
        this.reactions.put(Reaction.LOVE, 0);
    }

    public int getArticleId() {
        return articleId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public OffsetDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public OffsetDateTime getModifiedDateTime() {
        return modifiedDateTime;
    }

    public String getAuthor() {
        return author;
    }

    public ArrayList<Comment> getComments() {
        Comment[] commentArray = comments.values().toArray(new Comment[0]);
        Comment tempComment;
        int max = 0;
        for (int i = 0; i < commentArray.length - 1; i++) {
            max = i;
            for (int j = i + 1; j < commentArray.length; j++) {
                if (commentArray[j].getDifferenceVoteCount() > commentArray[max].getDifferenceVoteCount()) {
                    max = j;
                }
            }
            tempComment = commentArray[i];
            commentArray[i] = commentArray[max];
            commentArray[max] = tempComment;
        }

        return new ArrayList<>(Arrays.asList(commentArray));
    }

    public int getReactionCountByType(Reaction reactionType) {
        return reactions.get(reactionType);
    }

    public void updateTitle(String title) {
        setTitle(title);
        setModifiedDateTime(OffsetDateTime.now());
    }

    public void updateContent(String content) {
        setContent(content);
        setModifiedDateTime(OffsetDateTime.now());
    }

    public void addTag(String tag) {
        if (!this.tags.contains(tag)) {
            this.tags.add(tag);
        }
    }

    public void removeTag(String tag) {
        this.tags.remove(tag);
    }

    public void addComment(Comment comment) {
        int commentId = comment.getCommentId();
        comments.put(commentId, comment);
    }

    public void addReaction(Reaction reactionType) {
        reactions.put(reactionType, reactions.get(reactionType) + 1);
    }

    public boolean tryRemoveReaction(Reaction reactionType) {
        if (reactions.get(reactionType) > 0) {
            reactions.put(reactionType, reactions.get(reactionType) - 1);
            return true;
        } else {
            return false;
        }
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setContent(String content) {
        this.content = content;
    }

    private void setModifiedDateTime(OffsetDateTime modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }

}
