package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;


public class App {
    public App(Registry registry) {
        // Register like this
        //registry.registerPostAdder("Foo", "bar");

        registry.registerBlogCreator("Blog");
        registry.registerTagFilterSetter("Blog", "tagFilterSetter");
        registry.registerAuthorFilterSetter("Blog", "authorFilterSetter");
        registry.registerPostOrderSetter("Blog", "setSortingType");
        registry.registerPostListGetter("Blog", "postListGetter");
        registry.registerPostAdder("Blog", "postAdder");
        registry.registerPostTitleUpdater("Post", "setTitle");
        registry.registerPostBodyUpdater("Post", "setBody");
        registry.registerPostTagAdder("Post", "tagAdder");
        registry.registerCommentAdder("Post", "commentAdder");
        registry.registerSubcommentAdder("Comment", "subcommentAdder");
        registry.registerCommentUpdater("Comment", "setBody");
        registry.registerSubcommentUpdater("Comment", "setBody");
        registry.registerReactionAdder("Post", "reactionAdder");
        registry.registerReactionRemover("Post", "reactionRemover");
        registry.registerCommentUpvoter("Comment", "commentUpvoter");
        registry.registerCommentDownvoter("Comment", "commentDownvoter");
        registry.registerCommentListGetter("Post", "getComments");
        registry.registerSubcommentListGetter("Comment", "getSubcomment");
        registry.registerSubcommentUpvoter("Comment", "commentUpvoter");
        registry.registerSubcommentDownvoter("Comment", "commentDownvoter");

    }
}

/*
registerBlogCreator(): 블로그를 생성하는 생성자를 등록한다.
registerTagFilterSetter(): 태그 필터를 설정하는 메서드를 등록한다.
registerAuthorFilterSetter(): 작성자 필터를 설정하는 메서드를 등록한다.
registerPostOrderSetter(): 블로그 글의 정렬 방법을 설정하는 메서드를 등록한다.
registerPostListGetter(): 블로그 글 목록을 가져오는 메서드를 등록한다.
registerPostAdder(): 블로그에 글을 추가하는 메서드를 등록한다.
registerPostTitleUpdater(): 발행된 블로그 글의 제목을 바꾸는 메서드를 등록한다.
registerPostBodyUpdater(): 발행된 블로그 글의 본문을 바꾸는 메서드를 등록한다.
registerPostTagAdder(): 블로그 글에 태그를 추가하는 메서드를 등록한다.
registerCommentAdder(): 블로그 글에 댓글을 추가하는 메서드를 등록한다.
registerSubcommentAdder(): 댓글에 하위 댓글을 추가하는 메서드를 등록한다.
registerCommentUpdater(): 댓글의 내용을 바꾸는 메서드를 등록한다.
registerSubcommentUpdater(): 하위 댓글의 내용을 바꾸는 메서드를 등록한다.
registerReactionAdder(): 블로그 글에 리액션을 추가하는 메서드를 등록한다.
registerReactionRemover(): 블로그 글로부터 리액션을 제거하는 메서드를 등록한다.
registerCommentUpvoter(): 댓글을 추천하는 메서드를 등록한다.
registerCommentDownvoter(): 댓글을 비추천하는 메서드를 등록한다.
registerCommentListGetter(): 블로그 글에 달린 댓글들을 가져오는 메서드를 등록한다.
registerSubcommentListGetter(): 댓글에 달린 하위 댓글들을 가져오는 메서드를 등록한다.
registerSubcommentUpvoter(): 하위 댓글을 추천하는 메서드를 등록한다.
registerSubcommentDownvoter(): 하위 댓글을 비추천하는 메서드를 등록한다.
 */
