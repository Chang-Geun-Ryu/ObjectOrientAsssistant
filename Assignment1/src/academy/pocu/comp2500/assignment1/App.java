package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        registry.registerBlogCreator("Blog");
        registry.registerTagFilterSetter("Blog", "getPostsByTag");
        registry.registerAuthorFilterSetter("Blog", "getPostsByAuthorId");
        registry.registerPostOrderSetter("Blog", "getSortPosts");
        registry.registerPostListGetter("Blog", "getPosts");
        registry.registerPostAdder("Blog", "addPost");
        registry.registerPostTitleUpdater("Blog", "renamePostTitle");
        registry.registerPostBodyUpdater("Blog", "renamePostText");
        registry.registerPostTagAdder("Post", "addTag");
        registry.registerCommentAdder("Post", "AddComment");
        registry.registerSubcommentAdder("Comment", "addSubComment");
        registry.registerCommentUpdater("Comment", "renameComment");
        registry.registerSubcommentUpdater("Comment", "renameComment");
        registry.registerReactionAdder("Post", "AddOrSubReaction");
        registry.registerReactionRemover("Post", "AddOrSubReaction");
        registry.registerCommentUpvoter("Comment", "addUpVote");
        registry.registerCommentDownvoter("Comment", "addDownVote");
        registry.registerCommentListGetter("Post", "getComments");
        registry.registerSubCommentListGetter("Comment", "getSubComments");
        registry.registerSubcommentUpvoter("Comment", "addUpVote");
        registry.registerSubcommentDownvoter("Comment", "addDownVote");
    }
}
