package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        String blog = "Blog";
        String post = "Post";
        String comment = "Comment";

        registry.registerBlogCreator(blog);
        registry.registerTagFilterSetter(blog, "setPostTagFilter");
        registry.registerAuthorFilterSetter(blog, "setPostWriterFilter");
        registry.registerPostOrderSetter(blog, "setPostsSorting");
        registry.registerPostListGetter(blog, "getPosts");
        registry.registerPostAdder(blog, "posting");
        registry.registerPostTitleUpdater(post, "updateTitle");
        registry.registerPostBodyUpdater(post, "updateBody");
        registry.registerPostTagAdder(post, "addTag");
        registry.registerCommentAdder(post, "addComment");
        registry.registerSubcommentAdder(comment, "addSubComment");
        registry.registerCommentUpdater(comment, "updateText");
        registry.registerSubcommentUpdater(comment, "updateText");
        registry.registerReactionAdder(post, "addReaction");
        registry.registerReactionRemover(post, "removeReaction");
        registry.registerCommentUpvoter(comment, "upvote");
        registry.registerCommentDownvoter(comment, "downvote");
        registry.registerCommentListGetter(post, "getComments");
        registry.registerSubcommentListGetter(comment, "getSubCommentsRecursive");
        registry.registerSubcommentUpvoter(comment, "upvote");
        registry.registerSubcommentDownvoter(comment, "downvote");
    }
}
