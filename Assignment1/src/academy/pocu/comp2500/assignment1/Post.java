package academy.pocu.comp2500.assignment1;

//import java.time.LocalDateTime;
//import java.time.ZoneOffset;

import java.time.OffsetDateTime;
import java.util.ArrayList;

public class Post {
    private String author;
    private String title;
    private String content;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;// = OffsetDateTime.of(LocalDateTime.of(1997, 3, 1, 0, 0, 0), ZoneOffset.of("+9"));
    private OffsetDateTime postId;
    private ArrayList<String> tagListInPost;
    private ArrayList<Comment> comments;
    private int[] reaction = new int[5];
    private final int GREAT = 0;
    private final int SAD = 1;
    private final int ANGRY = 2;
    private final int FUN = 3;
    private final int LOVE = 4;

    public Post(User author, String title, String content) {
        this.title = title;
        this.content = content;
        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = OffsetDateTime.now(); // <-수정날짜 초기화를 내 생일말고 이걸로해봄
        this.postId = author.getUserId();
        this.author = author.getNickname();
        tagListInPost = new ArrayList<String>();
        comments = new ArrayList<Comment>();
    }

    /*
    public Post(User author, String title, String content, String tag) {
        this.title = title;
        this.content = content;
        this.createdDateTime = OffsetDateTime.now();
        this.postId = author.getUserId();
        this.author = author.getNickname();
        tagListInPost = new ArrayList<String>();
        tagListInPost.add(tag);
        comments = new ArrayList<Comment>();
    }
     */
    public ArrayList<Comment> getCommentList() {
        comments.sort((comment1, comment2) -> {
            if ((comment1.getUpvote() - comment1.getDownvote()) - (comment2.getUpvote() - comment2.getDownvote()) > 0) {
                return -1;
            } else if ((comment1.getUpvote() - comment1.getDownvote()) - (comment2.getUpvote() - comment2.getDownvote()) < 0) {
                return 1;
            }
            return 0;
        });
        return comments;
    }

    public void addComment(Comment comment) {
        comment.setCommentId(postId);
        comments.add(comment);
    }

    public boolean matchTag(ArrayList<String> tagList) {
        boolean match = false;
        for (String tag : tagList
        ) {
            if (tagListInPost.contains(tag)) {
                match = true;
                break;
            }
        }
        return match;
    }

    //이거 밑에  if (tag.isBlank()) {
    //                System.out.println("You have to write tag."); 이거 수정한 거임
   /* public void addTag(String tag) {
        if (tag.isBlank() || tagListInPost.contains(tag)) {
            System.out.println("You have to write another tag.");
        } else {
            tagListInPost.add(tag);
        }
    }*/

    //이거 밑에 지워야할 수도 있음, addTag 부분에 if (postId.compareTo(author.getUserId()) == 0) 추가했음
    public void addTag(ArrayList<String> tags) {
        for (String tag : tags
        ) {
            if (tag.isBlank() || tagListInPost.contains(tag)) {
                System.out.println("You have to write another tag.");
            } else {
                tagListInPost.add(tag);
            }
        }
    }

    public void addTag(String... tags) {
        for (String tag : tags
        ) {
            if (tag.isBlank() || tagListInPost.contains(tag)) {
                System.out.println("You have to write another tag.");
            } else {
                tagListInPost.add(tag);
            }
        }
    }

    public ArrayList<String> getTagListInPost() {
        return tagListInPost;
    }

    public void addReaction(EmojiType emojiType) {
        switch (emojiType) {
            case GREAT:
                reaction[0]++;
                break;
            case SAD:
                reaction[1]++;
                break;
            case ANGRY:
                reaction[2]++;
                break;
            case FUN:
                reaction[3]++;
                break;
            case LOVE:
                reaction[4]++;
                break;
            default:
                assert (false) : "Unrecognized sorting type: " + emojiType;
                break;
        }
    }

    public void removeReaction(EmojiType emojiType) {
        switch (emojiType) {
            case GREAT:
                if (reaction[0] - 1 < 0) {
                    reaction[0] = 0;
                } else {
                    reaction[0]--;
                }
                break;
            case SAD:
                if (reaction[1] - 1 < 0) {
                    reaction[1] = 0;
                } else {
                    reaction[1]--;
                }
                break;
            case ANGRY:
                if (reaction[2] - 1 < 0) {
                    reaction[2] = 0;
                } else {
                    reaction[2]--;
                }
                break;
            case FUN:
                if (reaction[3] - 1 < 0) {
                    reaction[3] = 0;
                } else {
                    reaction[3]--;
                }
                break;
            case LOVE:
                if (reaction[4] - 1 < 0) {
                    reaction[4] = 0;
                } else {
                    reaction[4]--;
                }
                break;
            default:
                assert (false) : "Unrecognized sorting type: " + emojiType;
                break;
        }
    }

    public String getAuthor() {
        return author;
    }

    public OffsetDateTime getPostTime() {
        return this.createdDateTime;
    }

    public OffsetDateTime getModifyTime() {
        return this.modifiedDateTime;
    }

    public String getTitle() {
        return title;
    }

    public void updatePostTitle(User author, String title) {
        if (author.getUserId().compareTo(this.postId) == 0) {
            this.title = title;
            this.modifiedDateTime = OffsetDateTime.now();
        } else {
            System.out.println("Author only update title.");
        }
    }

    public String getContent() {
        return content;
    }

    public void updatePostBody(User author, String content) {
        if (author.getUserId().compareTo(this.postId) == 0) {
            this.content = content;
            this.modifiedDateTime = OffsetDateTime.now();
        } else {
            System.out.println("Author only update content.");
        }
    }

    public OffsetDateTime getPostId() {
        return postId;
    }

    public int getReaction(EmojiType emojiType) {
        int reactionCount = 0;
        switch (emojiType) {
            case GREAT:
                reactionCount = reaction[0];
                break;
            case SAD:
                reactionCount = reaction[1];
                break;
            case ANGRY:
                reactionCount = reaction[2];
                break;
            case FUN:
                reactionCount = reaction[3];
                break;
            case LOVE:
                reactionCount = reaction[4];
                break;
            default:
                assert (false) : "Unrecognized sorting type: " + emojiType;
                break;
        }
        return reactionCount;
    }
}
