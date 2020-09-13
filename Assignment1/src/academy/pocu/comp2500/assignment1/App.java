package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        registry.registerBlogCreator("Blog");
        registry.registerTagFilterSetter("Blog", "setTagFilters");
        registry.registerAuthorFilterSetter("Blog", "setAuthorFilters");
        registry.registerPostOrderSetter("Blog", "setSortingType");
        registry.registerPostListGetter("Blog", "getPosts");
        registry.registerPostAdder("Blog", "addPost");
        registry.registerPostTitleUpdater("Post", "setTitle");
        registry.registerPostBodyUpdater("Post", "setText");
        registry.registerPostTagAdder("Post", "addTag");
        registry.registerCommentAdder("Post", "addComment");
        registry.registerSubcommentAdder("Comment", "addSubcomment");
        registry.registerCommentUpdater("Comment", "setText");
        registry.registerSubcommentUpdater("Comment", "setText");
        registry.registerReactionAdder("Post", "addReaction");
        registry.registerReactionRemover("Post", "removeReaction");
        registry.registerCommentUpvoter("Comment", "addUpvote");
        registry.registerCommentDownvoter("Comment", "addDownvote");
        registry.registerCommentListGetter("Post", "getComments");
        registry.registerSubcommentListGetter("Comment", "getSubcomments");
        registry.registerSubcommentUpvoter("Comment", "addUpvote");
        registry.registerSubcommentDownvoter("Comment", "addDownvote");
    }
}
