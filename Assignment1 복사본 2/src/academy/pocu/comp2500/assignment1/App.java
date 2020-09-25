package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerPostAdder("Foo", "bar");
        registry.registerBlogCreator("JeBlog");
        registry.registerTagFilterSetter("JeBlog", "setTagFilter");
        registry.registerAuthorFilterSetter("JeBlog", "setAuthorFilter");
        registry.registerPostOrderSetter("JeBlog", "setSortingType");
        registry.registerPostListGetter("JeBlog", "getPostList");
        registry.registerPostAdder("JeBlog", "addPost");
        registry.registerPostTitleUpdater("JePost", "modifyPostTitle");
        registry.registerPostBodyUpdater("JePost", "modifyContent");
        registry.registerPostTagAdder("JePost", "addTag");
        registry.registerCommentAdder("JePost", "addComment");
        registry.registerSubcommentAdder("JeComment", "addSubComment");
        registry.registerCommentUpdater("JeComment", "modifyComment");
        registry.registerSubcommentUpdater("JeComment", "modifyComment");
        registry.registerReactionAdder("JePost", "addReaction");
        registry.registerReactionRemover("JePost", "removeReaction");
        registry.registerCommentUpvoter("JeComment", "recommend");
        registry.registerCommentDownvoter("JeComment", "notRecommend");
        registry.registerCommentListGetter("JePost", "getComments");
        registry.registerSubcommentListGetter("JeComment", "getSubComments");
        registry.registerSubcommentUpvoter("JeComment", "recommend");
        registry.registerSubcommentDownvoter("JeComment", "notRecommend");
    }
}