package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Comparator;

public class JeComment {
    private JeAuthor author;
    private int userId;
    private String content;
    private int commentId;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    private ArrayList<JeComment> subComments;
    private HashSet<Integer> recommendList;
    private HashSet<Integer> notRecommendList;

    public JeComment(JeAuthor author, String content) {
        this.author = author;
        userId = author.getId();
        this.content = content;
        commentId = (author.getName() + this).hashCode();
        createdDateTime = OffsetDateTime.now();
        modifiedDateTime = OffsetDateTime.now();
        subComments = new ArrayList<>();
        recommendList = new HashSet<>();
        notRecommendList = new HashSet<>();
    }

    public JeAuthor getAuthor() {
        return author;
    }

    public int getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public int getCommentId() {
        return commentId;
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

    // 11. 댓글에 하위 댓글을 추가하는 메서드를 등록한 다.
    public void addSubComment(JeComment comment) {
        subComments.add(comment);
    }

    // 12. 댓글의 내용을 바꾸는 메서드를 등록한다.
    // 13. 하위 댓글의 내용을 바꾸는 메서드를 등록한다.
    public void modifyComment(JeAuthor author, String content) {
        if (author.getId() == userId) {
            this.content = content;
            modifiedDateTime = OffsetDateTime.now();
        }
    }

    // 16. 댓글을 추천하는 메서드를 등록한다.
    // 20. 하위 댓글을 추천하는 메서드를 등록한다.
    public void recommend(JeAuthor author) {
        if (recommendList.contains(author.getId())) {
            return;
        } else {
            recommendList.add(author.getId());
        }
    }

    // 17. 댓글을 비추천하는 메서드를 등록한다
    // 21. 하위 댓글을 비추천하는 메서드를 등록한다.
    public void notRecommend(JeAuthor author) {
        if (notRecommendList.contains(author.getId())) {
            return;
        } else {
            notRecommendList.add(author.getId());
        }
    }

    // 19. 댓글에 달린 하위 댓글들을 가져오는 메서드를 등록한다.
    public ArrayList<JeComment> getSubComments() {
        subComments.sort((c1, c2) -> (c2.getRecommend() - c2.getNotRecommend()) - (c1.getRecommend() - c1.getNotRecommend()));
        return subComments;
    }
}
