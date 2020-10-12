package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerPostAdder("Foo", "bar");
        registry.registerBlogCreator("Blog");
        registry.registerTagFilterSetter("Blog", "setTagFilters");
        registry.registerAuthorFilterSetter("Blog", "setAuthorFilter");
        registry.registerPostOrderSetter("Blog", "sort");
        registry.registerPostListGetter("Blog", "getPosts");
        registry.registerPostAdder("Blog", "addPost");
        registry.registerPostTitleUpdater("Post", "modifyTitle");
        registry.registerPostBodyUpdater("Post", "modifyContent");
        registry.registerPostTagAdder("Post", "addTag");
        registry.registerCommentAdder("Post", "addComment");
        registry.registerSubcommentAdder("Comment", "addSubcomment");
        registry.registerCommentUpdater("Comment", "setText");
        registry.registerSubcommentUpdater("Comment", "modifySubcomment");
        registry.registerReactionAdder("Post", "addReaction");
        registry.registerReactionRemover("Post", "removeReaction");
        registry.registerCommentUpvoter("Comment", "addUpvote");
        registry.registerCommentDownvoter("Comment", "addDownvote");
        registry.registerCommentListGetter("Post", "getComments");
        registry.registerSubcommentListGetter("Comment", "getSubcomments");
        registry.registerSubcommentUpvoter("Comment", "upvoteSubcomment");
        registry.registerSubcommentDownvoter("Comment", "downvoteSubcomment");
    }
}
