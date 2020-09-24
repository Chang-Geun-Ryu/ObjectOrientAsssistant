package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class JePost {
    private JeAuthor author;
    private String title;
    private String content;
    private int postId;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    private ArrayList<JeComment> comments;
    private HashSet<String> tags;
    private HashSet<Integer> recommendList;
    private HashSet<Integer> notRecommendList;
    private HashMap<Integer, EReaction> reactions;
    private int great;
    private int sad;
    private int angry;
    private int fun;
    private int love;

    public JePost(String title, String content, JeAuthor author) {
        this.author = author;
        this.title = title;
        this.content = content;
        postId = (author.getName() + title + this).hashCode();
        createdDateTime = OffsetDateTime.now();
        modifiedDateTime = OffsetDateTime.now();
        comments = new ArrayList<>();
        tags = new HashSet<>();
        recommendList = new HashSet<>();
        notRecommendList = new HashSet<>();
        reactions = new HashMap<>();
    }

    public JeAuthor getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getPostId() {
        return postId;
    }

    public HashSet<String> getTags() {
        return tags;
    }

    public HashMap<Integer, EReaction> getReactions() {
        return reactions;
    }

    public OffsetDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public OffsetDateTime getModifiedDateTime() {
        return modifiedDateTime;
    }

    public int getRecommend() {
        return recommendList.size();
    }

    public int getNotRecommend() {
        return notRecommendList.size();
    }

    // 7. 발행된 블로그 글의 제목을 바꾸는 메서드를 등록한다.
    public void modifyPostTitle(String title) {
        this.title = title;
        modifiedDateTime = OffsetDateTime.now();
    }

    // 8. 발행된 블로그 글의 본문을 바꾸는 메서드를 등록한다.
    public void modifyContent(String content) {
        this.content = content;
        modifiedDateTime = OffsetDateTime.now();
    }

    // 9. 블로그 글에 태그를 추가하는 메서드를 등록한다.
    public void addTag(String tag) {
        tags.add(tag);
    }

    public boolean isHaveTag(HashSet<String> tags) {
        if (tags.size() == 0) {
            return true;
        }
        for (String tag : tags) {
            if (this.tags.contains(tag)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAuthor(HashSet<Integer> authors) {
        if (authors.size() == 0) {
            return true;
        }
        if (authors.contains(this.author.getId())) {
            return true;
        } else {
            return false;
        }
    }

    // 10. 블로그 글에 댓글을 추가하는 메서드를 등록한다.
    public void addComment(JeComment comment) {
        comments.add(comment);
    }

    // 14. 블로그 글에 리액션을 추가하는 메서드를 등록한다.
    public void addReaction(JeAuthor author, EReaction emoji) {
        if (reactions.containsKey(author.getId())) {
            removeReaction(author, reactions.get(author.getId()));
        }
        reactions.put(author.getId(), emoji);
        switch (emoji) {
            case GREAT:
                great++;
                break;
            case SAD:
                sad++;
                break;
            case ANGRY:
                angry++;
                break;
            case FUN:
                fun++;
                break;
            case LOVE:
                love++;
                break;
        }
    }

    // 15. 블로그 글로부터 리액션을 제거하는 메서드를 등록한다.
    public void removeReaction(JeAuthor author, EReaction emoji) {
        if (reactions.containsKey(author.getId())) {
            reactions.remove(author.getId());
            switch (emoji) {
                case GREAT:
                    great--;
                    break;
                case SAD:
                    sad--;
                    break;
                case ANGRY:
                    angry--;
                    break;
                case FUN:
                    fun--;
                    break;
                case LOVE:
                    love--;
                    break;
            }
        }
    }

    public int getReaction(EReaction emoji) {
        switch (emoji) {
            case GREAT:
                return great;
            case ANGRY:
                return angry;
            case SAD:
                return sad;
            case FUN:
                return fun;
            case LOVE:
                return love;
            default:
                assert false;
        }
        return -1;
    }

    // 18. 블로그 글에 달린 댓글들을 가져오는 메서드를 등록한다.
    public ArrayList<JeComment> getComments() {
        comments.sort((c1, c2) -> (c2.getRecommend() - c2.getNotRecommend()) - (c1.getRecommend() - c1.getNotRecommend()));
        return comments;
    }

    public void recommend(JeAuthor author) {
        if (recommendList.contains(author.getId())) {
            return;
        } else {
            recommendList.add(author.getId());
        }
    }

    public void notRecommend(JeAuthor author) {
        if (notRecommendList.contains(author.getId())) {
            return;
        } else {
            notRecommendList.add(author.getId());
        }
    }
}
