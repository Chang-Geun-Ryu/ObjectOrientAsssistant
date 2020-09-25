package academy.pocu.comp2500.assignment1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Blog {
    private User host;
    private ArrayList<Post> posts;
    private SortingType sortingType;
    private ArrayList<String> tagFilter;
    private String authorFilter;

    public void setSortingType(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    private Blog() {
        super();
        posts = new ArrayList<Post>();
        sortingType = SortingType.CREATELOWER;
        authorFilter = null;
        tagFilter = new ArrayList<>();
    }

    public Blog(User user) {
        this();
        host = user;
    }

    public void postAdder(Post post) {
        posts.add(post);
    }

    public ArrayList<Post> postListGetter() {
        ArrayList<Post> result = getList();
        switch (sortingType) {
            case CREATELOWER:
                result.sort((o1, o2) -> {
                    if (o1.getCreatedDateTime().isBefore(o2.getCreatedDateTime())) {
                        return 1;
                    } else {
                        return 0;
                    }
                });
                break;
            case CREATEUPPER:
                result.sort((o1, o2) -> {
                    if (o1.getCreatedDateTime().isAfter(o2.getCreatedDateTime())) {
                        return 1;
                    } else {
                        return 0;
                    }
                });
                break;
            case MODIFIEDLOWER:
                result.sort((o1, o2) -> {
                    if (o1.getModifiedDateTime().isBefore(o2.getModifiedDateTime())) {
                        return 1;
                    } else {
                        return 0;
                    }
                });
                break;
            case MODIFIEDUPPER:
                result.sort((o1, o2) -> {
                    if (o1.getModifiedDateTime().isAfter(o2.getModifiedDateTime())) {
                        return 1;
                    } else {
                        return 0;
                    }
                });
                break;
            case TITLE:
                result.sort(Comparator.comparing(o -> o.getTitle()));
                break;
            default:
                break;
        }
        return result;
    }

    public ArrayList<Post> getList() {
        ArrayList<Post> result = posts.stream().filter(post -> filterFunc(post)).collect(Collectors.toCollection(ArrayList::new));
        return result;
    }

    private boolean filterFunc(Post post) {
        boolean isTagPass = true;
        boolean isAuthorPass = true;
        if (tagFilter.size() > 0) {

            boolean temp = false;
            for (String t : tagFilter) {
                if (post.getTags().contains(t)) {
                    temp = true;
                    break;
                }
            }
            if (!temp) {
                isTagPass = false;
            }
        }

        if (this.authorFilter != null) {
            if (this.authorFilter != post.getAuthor().getNickname()) {
                isAuthorPass = false;
            }
        }

        return isTagPass && isAuthorPass;
    }

    public void authorFilterSetter(String nickname) {
        if (nickname == null) {
            return;
        }
        this.authorFilter = nickname;
    }

    public void tagFilterSetter(String tag) {
        if (this.tagFilter.contains(tag)) {
            return;
        }
        if (tag == null) {
            return;
        }
        if (tag.length() == 0) {
            return;
        }
        this.tagFilter.add(tag);
    }

    public void tagFilterClear() {
        this.tagFilter.clear();
    }

    public void authorFilterClear() {
        this.authorFilter = null;
    }
}
