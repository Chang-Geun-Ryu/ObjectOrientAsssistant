package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerPostAdder("Foo", "bar");
        registry.registerBlogCreator("Blog");

        registry.registerTagFilterSetter("Blog", "setTagsFilter");
        registry.registerAuthorFilterSetter("Blog", "setAuthorsFilter");

        registry.registerPostOrderSetter("Blog", "setArticleOrder");

        registry.registerPostListGetter("Blog", "getArticles");

        registry.registerPostAdder("Blog", "createArticle");
        registry.registerPostTitleUpdater("Article", "setTitle");
        registry.registerPostBodyUpdater("Article", "setContent");
        registry.registerPostTagAdder("Article", "addTag");

        registry.registerCommentAdder("Article", "createComment");
        registry.registerSubcommentAdder("Comment", "addSubcomment");
        registry.registerCommentUpdater("Comment", "setComment");
        registry.registerSubcommentUpdater("Comment", "setComment");

        registry.registerReactionAdder("Article", "addReaction");
        registry.registerReactionRemover("Article", "removeReaction");

        registry.registerCommentUpvoter("Comment", "addUpvote");
        registry.registerCommentDownvoter("Comment", "addDownvote");

        registry.registerCommentListGetter("Article", "getComments");
        registry.registerSubcommentListGetter("Comment", "getSubcomments");

        registry.registerSubcommentUpvoter("Comment", "addUpvote");
        registry.registerSubcommentDownvoter("Comment", "addDownvote");
    }
}

