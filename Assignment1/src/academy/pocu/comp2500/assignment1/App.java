package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerPostAdder("Foo", "bar");

        //1. 블로그 생성자
        registry.registerBlogCreator("Blog");

        //2. Tag filter 설정
        registry.registerTagFilterSetter("Blog", "setTagFilter");

        //3. 작성자 필터 설정
        registry.registerAuthorFilterSetter("Blog", "setAuthorFilter");

        //4. 블로그 글의 정렬 방법 설정
        registry.registerPostOrderSetter("Blog", "setSortingType");

        //5. 블로그 글 목록을 가져오는 메서드 등록
        registry.registerPostListGetter("Blog", "getArticles");

        //6. 블로그에 글을 추가하는 메서드를 등록
        registry.registerPostAdder("Blog", "addArticle");

        //7. 발행된 블로그 글의 제목을 바꾸는 메서드를 등록
        registry.registerPostTitleUpdater("Article", "updateTitle");

        //8. 발행된 블로그 글의 본문을 바꾸는 메서드를 등록
        registry.registerPostBodyUpdater("Article", "updateContent");

        //9. 블로그 글에 태그를 추가하는 메서드를 등록
        registry.registerPostTagAdder("Article", "addTag");

        //10. 블로그 글에 댓글을 추가하는 메서드를 등록
        registry.registerCommentAdder("Article", "addComment");

        //11. 댓글에 하위 댓글을 추가하는 메서드를 등록
        registry.registerSubcommentAdder("Comment", "addSubcomment");

        //12. 댓글의 내용을 바꾸는 메서드를 등록
        registry.registerCommentUpdater("Comment", "updateComment");

        //13. 하위댓글의 내용을 바꾸는 메서드를 등록
        registry.registerSubcommentUpdater("Comment", "updateComment");

        //14. 블로그 글에 리액션을 추가하는 메서드를 등록
        registry.registerReactionAdder("Article", "addReaction");

        //15. 블로그 글로부터 리액션을 제거하는 메서드를 등록
        registry.registerReactionRemover("Article", "tryRemoveReaction");

        //16. 댓글을 추천하는 메서드를 등록
        registry.registerCommentUpvoter("Comment", "upvote");

        //17. 댓글을 비추천하는 메서드를 등록
        registry.registerCommentDownvoter("Comment", "downvote");

        //18. 블로그 글에 달린 댓글들을 가져오는 메서드를 등록
        registry.registerCommentListGetter("Article", "getComments");

        //19. 댓글에 달린 하위 댓글들을 가져오는 메서드를 등록
        registry.registerSubcommentListGetter("Comment", "getSubcomments");

        //20. 하위 댓글을 추천하는 메서드를 등록
        registry.registerSubcommentUpvoter("Comment", "upvote");

        //21. 하위 댓글을 비추천하는 메서드를 등록
        registry.registerSubcommentDownvoter("Comment", "downvote");
    }
}
