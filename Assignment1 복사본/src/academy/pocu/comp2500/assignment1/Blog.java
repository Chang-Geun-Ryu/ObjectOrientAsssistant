package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Blog {

    private final ArrayList<Post> posts = new ArrayList<>();
    private ArrayList<Post> filteringPosts = posts;

    public void posting(Post post) {
        posts.add(post);

        posts.sort((o1, o2) -> {
            if (o1.getCreateTime().isEqual(o2.getCreateTime())) {
                return 0;
            } else if (o1.getCreateTime().isAfter(o2.getCreateTime())) {
                return 1;
            } else {
                return -1;
            }
        });

        filteringPosts = posts;
    }

    public List<Post> getPosts() {
        return filteringPosts;
    }

    public void setPostTagFilter(List<String> tags) {
        ArrayList<Post> newFilteringPosts = new ArrayList<>();

        for (Post post : this.filteringPosts) {
            if (post.containTags(tags)) {
                newFilteringPosts.add(post);
            }
        }

        this.filteringPosts = newFilteringPosts;
    }

    public void setPostWriterFilter(User user) {
        ArrayList<Post> newFilteringPosts = new ArrayList<>();

        for (Post post : this.filteringPosts) {
            if (post.getUser() == user) {
                newFilteringPosts.add(post);
            }
        }

        this.filteringPosts = newFilteringPosts;
    }

    public void resetFilter() {
        this.filteringPosts = posts;
    }

    public void setPostsSorting(PostSortingType sortingType) {
        Comparator<Post> sortingComparator = null;

        switch (sortingType) {
            case CREATION_DATE_DESCENDING:
                sortingComparator = (post1, post2) -> post2.getCreateTime().compareTo(post1.getCreateTime());
                break;
            case CREATION_DATE_ASCENDING:
                sortingComparator = (post1, post2) -> post1.getCreateTime().compareTo(post2.getCreateTime());
                break;
            case MODIFICATION_DATE_DESCENDING:
                sortingComparator = (post1, post2) -> post2.getModificationTime().compareTo(post1.getModificationTime());
                break;
            case MODIFICATION_DATE_ASCENDING:
                sortingComparator = (post1, post2) -> post1.getModificationTime().compareTo(post2.getModificationTime());
                break;
            case TITLE_ASCENDING:
                sortingComparator = Comparator.comparing(Post::getTitle);
                break;
            default:
                assert false;
        }

        filteringPosts.sort(sortingComparator);
    }
}
