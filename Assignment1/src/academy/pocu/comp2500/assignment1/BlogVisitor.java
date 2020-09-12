/*
package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;



public class BlogVisitor {
    private final ArrayList<Content> contents;

    public BlogVisitor() {
        this.contents = new ArrayList<>();
    }

    public final void getContents(BlogHost blog) {
        this.contents.removeAll(this.contents);
        this.contents.addAll(blog.getAllContents());
    }

    public final void getTagContents(BlogHost blog, String tag) {
        this.contents.removeAll(this.contents);
        this.contents.addAll(blog.getTagContents(tag));
    }

    public final void getAurthorContents(BlogHost blog, String author) {
        this.contents.removeAll(this.contents);
        this.contents.addAll(blog.getBlogAuthorContents(author));
    }

    public final void getSortedContents(BlogHost blog, BlogHost.SortType sortingType) {
        this.contents.removeAll(this.contents);
        this.contents.addAll(blog.getSortContents(sortingType));
    }

    public final void readComments(Content post) {
        post.getComments().forEach(e -> {
            System.out.print(e.getComment());
        });
    }

    public final void readSubcomments(Comment comment) {
        comment.getComment();
    }

    public final void readSortedComments(Content post) {
        post.getSortedComments().forEach(e -> {
            System.out.print(e.getComment());
        });
    }

    public final void addComment(Content post, String text) {
        post.addComment(this, text);
    }

    public final void addSubComment(Comment comment, String text) {
        comment.addSubcomment(text);
    }

    public final void modifyComment(Comment comment, String text) {
        comment.setComment(text);
    }

    public final void modifySubcomment(Comment comment, String text) {
        comment.setComment(text);
    }

    public final void setReactionPost(Content post, Reaction.Type type) {
        post.setReactions(type,true);
    }

    public final void removeReactionPost(Content post, Reaction.Type type) {
        post.setReactions( type, false);
    }

    public final void upvote(Comment comment) {
        comment.addLike("1");
    }

    public final void doownvote(Comment comment) {
        comment.addHate(this);
    }
}
*/