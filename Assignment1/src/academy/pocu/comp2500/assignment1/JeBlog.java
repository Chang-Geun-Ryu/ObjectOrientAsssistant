package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.HashSet;

public class JeBlog {
    private String blogName;
    private int blogId;
    private ArrayList<JePost> postList;
    private HashSet<String> tagFilter;
    private HashSet<Integer> authorFilter;
    private ESortWay sortingType;

    // 1.블로그를 생성하는 생성자를 등록한다.
    public JeBlog(String name) {
        blogName = name;
        blogId = (blogName + this).hashCode();
        postList = new ArrayList<>();
        tagFilter = new HashSet<>();
        authorFilter = new HashSet<>();
        sortingType = ESortWay.WRITE_TIME_DESCENDING;
    }

    public int getBlogId() {
        return blogId;
    }

    // 2.태그 필터를 설정하는 메서드를 등록한다.
    public void setTagFilter(String... tags) {
        tagFilter.clear();
        if (tags.length == 0) {
            return;
        }
        for (int i = 0; i < tags.length; i++) {
            tagFilter.add(tags[i]);
        }
    }

    // 3. 작성자 필터를 설정하는 메서드를 등록한다.
    public void setAuthorFilter(JeAuthor... authors) {
        authorFilter.clear();
        if (authors.length == 0) {
            return;
        }
        for (int i = 0; i < authors.length; i++) {
            authorFilter.add(authors[i].getId());
        }
    }


    // 4. 블로그 글의 정렬 방법을 설정하는 메서드를 등록한다.
    public void setSortingType(ESortWay sortingType) {
        this.sortingType = sortingType;
        switch (sortingType) {
            case WRITE_TIME_DESCENDING:
                postList.sort((p1, p2) -> p2.getCreatedDateTime().compareTo(p1.getCreatedDateTime()));
                break;
            case WRITE_TIME_ASCENDING:
                postList.sort((p1, p2) -> p1.getCreatedDateTime().compareTo(p2.getCreatedDateTime()));
                break;
            case ADJUST_TIME_DESCENDING:
                postList.sort((p1, p2) -> p2.getModifiedDateTime().compareTo(p1.getModifiedDateTime()));
                break;
            case ADJUST_TIME_ASCENDING:
                postList.sort((p1, p2) -> p1.getModifiedDateTime().compareTo(p2.getModifiedDateTime()));
                break;
            case TITLE_DICTIONARY_ASCENDING:
                postList.sort((p1, p2) -> p1.getTitle().compareTo(p2.getTitle()));
                break;
        }
    }
    // 5. 블로그 글 목록을 가져오는 메서드

    /**
     * 1. 태그가 없다면 전체 목록을 반환
     * 2. 태그가 있다면 있는 것만 골라서 반환
     */
    public ArrayList<JePost> getPostList() {
        ArrayList<JePost> taggedPost = new ArrayList<>();
        for (JePost post : postList) {
            if (post.isHaveTag(tagFilter)
                    && post.isAuthor(authorFilter)) {
                taggedPost.add(post);
            }
        }
        return taggedPost;
    }

    // 6. 블로그에 글을 추가하는 메서드를 등록한다.
    public void addPost(JePost post) {
        postList.add(post);
    }
}
