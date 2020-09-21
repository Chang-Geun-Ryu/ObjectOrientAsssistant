package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        registry.registerBlogCreator("Blog"); // 블로그를 생성하는 생성자를 등록한다. Blog 클래스
        registry.registerTagFilterSetter("Blog", "tagFilter"); // 태그 필터를 설정하는 메서드를 등록한다.
        registry.registerAuthorFilterSetter("Blog", "authorFilter"); // 작성자 필터를 설정하는 메서드를 등록한다.
        registry.registerPostOrderSetter("Blog", "setSortingType"); // 블로그 글의 정렬 방법을 설정하는 메서드를 등록한다.
        registry.registerPostListGetter("Blog", "getPosts"); // 블로그 글 목록을 가져오는 메서드를 등록한다.
        registry.registerPostAdder("Blog", "addPost"); // 블로그에 글을 추가하는 메서드를 등록한다.
        registry.registerPostTitleUpdater("Post", "setTitle"); // 발행된 블로그 글의 제목을 바꾸는 메서드를 등록한다.
        registry.registerPostBodyUpdater("Post", "setBody"); // 발행된 블로그 글의 본문을 바꾸는 메서드를 등록한다.
        registry.registerPostTagAdder("Post", "addTag"); // 블로그 글에 태그를 추가하는 메서드를 등록한다.
        registry.registerCommentAdder("Post", "addComment"); // 블로그 글에 댓글을 추가하는 메서드를 등록한다.
        registry.registerSubcommentAdder("Comment", "addSubcomment"); // 댓글에 하위 댓글을 추가하는 메서드를 등록한다.
        registry.registerCommentUpdater("Comment", "updateComment"); // 댓글의 내용을 바꾸는 메서드를 등록한다.
        registry.registerSubcommentUpdater("Comment", "updateComment"); // 하위 댓글의 내용을 바꾸는 메서드를 등록한다.
        registry.registerReactionAdder("Post", "addReaction"); // 블로그 글에 리액션을 추가하는 메서드를 등록한다.
        registry.registerReactionRemover("Post", "removeReaction"); // 블로그 글로부터 리액션을 제거하는 메서드를 등록한다.
        registry.registerCommentUpvoter("Comment", "addUpvoteComment"); // 댓글을 추천하는 메서드를 등록한다.
        registry.registerCommentDownvoter("Comment", "addDownvoteComment"); // 댓글을 비추천하는 메서드를 등록한다.
        registry.registerCommentListGetter("Post", "getComments"); // 블로그 글에 달린 댓글들을 가져오는 메서드를 등록한다.
        registry.registerSubcommentListGetter("Comment", "getSubcomments"); // 댓글에 달린 하위 댓글들을 가져오는 메서드를 등록한다.
        registry.registerSubcommentUpvoter("Comment", "addUpvoteComment"); // 하위 댓글을 추천하는 메서드를 등록한다.
        registry.registerSubcommentDownvoter("Comment", "addDownvoteComment"); // 하위 댓글을 비추천하는 메서드를 등록한다.
    }
}
