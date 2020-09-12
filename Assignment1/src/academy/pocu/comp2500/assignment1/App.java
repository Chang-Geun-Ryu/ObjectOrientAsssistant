package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        registry.registerBlogCreator("Blog");
        registry.registerTagFilterSetter("Blog", "setTagFilter");
        registry.registerAuthorFilterSetter("Blog", "setAuthorFilter");
        registry.registerPostOrderSetter("Blog", "setPostOrder");
        registry.registerPostListGetter("Blog", "getPostList");
        registry.registerPostAdder("Blog", "addPost");
        registry.registerPostTitleUpdater("Post", "updatePostTitle");
        registry.registerPostBodyUpdater("Post", "updatePostBody");
        registry.registerPostTagAdder("Post", "addTag");
        registry.registerCommentAdder("Post", "addComment");
        registry.registerSubcommentAdder("Comment", "addSubcomment");
        registry.registerCommentUpdater("Comment", "updateComment");
        registry.registerSubcommentUpdater("Comment", "updateComment");
        registry.registerReactionAdder("Post", "addReaction");
        registry.registerReactionRemover("Post", "removeReaction");
        registry.registerCommentUpvoter("Comment", "upVote");
        registry.registerCommentDownvoter("Comment", "downVote");
        registry.registerCommentListGetter("Post", "getCommentList");
        registry.registerSubcommentListGetter("Comment", "getSubCommentList");
        registry.registerSubcommentUpvoter("Comment", "upVote");
        registry.registerSubcommentDownvoter("Comment", "downVote");
    }
}