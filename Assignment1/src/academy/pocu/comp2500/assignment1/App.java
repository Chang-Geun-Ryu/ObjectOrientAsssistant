package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        registry.registerBlogCreator("BlogHost");
        registry.registerTagFilterSetter("BlogHost", "setTags");
        registry.registerAuthorFilterSetter("BlogHost", "setAuthor");
        registry.registerPostOrderSetter("BlogHost", "setSortType");
        registry.registerPostListGetter("BlogHost", "getContents");
        registry.registerPostAdder("BlogHost", "addPost");
        registry.registerPostTitleUpdater("Content", "modifyPostTitle");
        registry.registerPostBodyUpdater("Content", "modifyPostBody");
        registry.registerPostTagAdder("Content", "addPostTag");
        registry.registerCommentAdder("Content", "addComment");
        registry.registerSubcommentAdder("Comment", "addSubcomment");
        registry.registerCommentUpdater("Comment", "setComment");
        registry.registerSubcommentUpdater("Comment", "setComment");
        registry.registerReactionAdder("Content", "setReaction");
        registry.registerReactionRemover("Content", "removeReaction");
        registry.registerCommentUpvoter("Comment", "addLike");
        registry.registerCommentDownvoter("Comment", "addHate");
        registry.registerCommentListGetter("Content", "getSortedComments");
        registry.registerSubcommentListGetter("Comment", "getSortedSubcomments");
        registry.registerSubcommentUpvoter("Comment", "addLike");
        registry.registerSubcommentDownvoter("Comment", "addHate");
    }
}
