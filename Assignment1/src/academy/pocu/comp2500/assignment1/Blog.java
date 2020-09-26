package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Blog {
    private User host;
    private ArrayList<Post> posts;
    private SortingType sortingType;
    private HashSet<String> tagFilter;
    private User authorFilter;

    public void setSortingType(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    private Blog() {
        super();
        posts = new ArrayList<Post>();
        sortingType = SortingType.CREATELOWER;
        authorFilter = null;
        tagFilter = new HashSet<String>();
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
        if (this.authorFilter != null) {
            if (!this.authorFilter.getNickname().equals(post.getAuthor().getNickname())) {
                return false;
            }
        }

        if (tagFilter.size() > 0) {
            if (post.getTags().size() == 0) {
                return false;
            }

//            for (String t : tagFilter) {
//                for (String tag : post.getTags()) {
//                    if (!tag.equals(t)) {
//                        return false;
//                    }
//                }
//            }

            boolean temp = false;
            for (String t : tagFilter) {
                if (post.getTags().contains(t)) {
                    temp = true;
                    break;
                }
            }
            return temp;
        }

        return true;
    }

    public void authorFilterSetter(User user) {
//        if (user == null) {
//            return;
//        }
        if (user == null) {
            authorFilterClear();
            return;
        }
        this.authorFilter = user;
    }

    public void tagFilterSetter(String tag) {

//        if (tag == null) {
//            return;
//        }
        if (tag == null) {
            tagFilterClear();
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

    public void tagFilterRemove(String tag) {
        this.tagFilter.remove(tag);
    }
    public void authorFilterRemove(User author) {
        if (this.authorFilter.equals(author)) {
            this.authorFilter = null;
        }
    }
}
